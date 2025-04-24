package com.OrderServies.OrderServies.Servies;

import brave.Span;
import brave.Tracer;
import com.OrderServies.OrderServies.Dto.InventoryResponse;
import com.OrderServies.OrderServies.Dto.OrderProductdto;
import com.OrderServies.OrderServies.Dto.Orderlineiteamdto;
import com.OrderServies.OrderServies.Event.OrderplaceEvent;
import com.OrderServies.OrderServies.Model.OrderProduct;
import com.OrderServies.OrderServies.Model.Orderlineiteam;
import com.OrderServies.OrderServies.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderproductServiesimpl  implements  OrderproductServies{


     @Autowired
     private OrderRepository orderproductRepository;

     @Autowired
     private WebClient.Builder webClient;

     @Autowired
     private KafkaTemplate<String, OrderplaceEvent> kafkaTemplate;

     @Autowired
     private  Tracer tracer;

    @Override
    public OrderProductdto setOrderproduct(OrderProductdto orderproductDto) {

        OrderProduct orderproduct = getOrderproduct(orderproductDto);

        List<String> skocd = orderproductDto.getOrderlineiteamdto().stream().map(
                sko -> sko.getSkcode()
        ).toList();


        Span inventorylook = tracer.nextSpan().name("inventorylook");

       try( Tracer.SpanInScope spanInScope = tracer.withSpanInScope(inventorylook.start()))
       {

           InventoryResponse[] skcods = webClient.build().get()
                   .uri("/get/inventoryitem",
                           uriBuilder -> uriBuilder.queryParam("skcod", skocd).build())
                   .retrieve()
                   .bodyToMono(InventoryResponse[].class)
                   .block();

           boolean b = Arrays.stream(skcods)
                   .allMatch(inventoryResponse -> inventoryResponse.isAvailable());
           if (!b) {
               throw new RuntimeException(" Product qty is Not enough inventory");
           }
           orderproductRepository.save(orderproduct);
           kafkaTemplate.send("notificationTopic", new OrderplaceEvent(orderproductDto.getOrderNumber()));

           return orderproductDto;
       }
       finally {
           inventorylook.flush();
       }




    }
    private OrderProduct getOrderproduct(OrderProductdto orderProductdto) {
        List<Orderlineiteamdto> orderlineiteam = orderProductdto.getOrderlineiteamdto();
        List<Orderlineiteam> listproduct = orderlineiteam.stream().map(orderlist -> getOrderlineiteam(orderlist))
                .collect(Collectors.toList());

        OrderProduct Orddprudct = OrderProduct.builder().orderNumber(orderProductdto.getOrderNumber())

                .Orderlineiteam(listproduct).build();
        listproduct.forEach(Orderlineiteams->Orderlineiteams.setOrderproduct(Orddprudct));
        return  Orddprudct ;
    }

    private Orderlineiteam getOrderlineiteam(Orderlineiteamdto orderlineiteam)
    {

        Orderlineiteam Orderlineitea  = Orderlineiteam.builder().price(orderlineiteam.getPrice())
                .skcode(orderlineiteam.getSkcode()).quantity(orderlineiteam.getQuantity()).build();
        return  Orderlineitea;
    }



}
