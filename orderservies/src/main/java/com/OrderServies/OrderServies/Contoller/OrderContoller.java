package com.OrderServies.OrderServies.Contoller;

import com.OrderServies.OrderServies.Dto.OrderProductdto;
import com.OrderServies.OrderServies.Servies.OrderproductServiesimpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/orderproduct")
@Tag(name = "Order Product", description = "API for managing order products"  )
@Slf4j
public class OrderContoller {


    @Autowired
    private OrderproductServiesimpl orderproductServies;

    @Operation(description = "Place an order")
    @PostMapping("/placeOrder")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "inventory")
    @Retry(name = "inventory")
    public CompletableFuture<ResponseEntity<?>> orderPlace(@RequestBody OrderProductdto orderproductDto)
    {

          return CompletableFuture.supplyAsync(()-> {

              OrderProductdto orderproductDto1 = orderproductServies.setOrderproduct(orderproductDto);
              log.info("calling order servi to inventoryie");
              return new ResponseEntity<>(orderproductDto1, HttpStatus.CREATED);
          });
    }


    public  CompletableFuture<ResponseEntity<String>> fallbackMethod(OrderProductdto orderProductdto, Throwable throwable) {
         return  CompletableFuture.completedFuture(
         new ResponseEntity<>("Ops, inventory service is down", HttpStatus.SERVICE_UNAVAILABLE)
    );

    }



    @GetMapping("/place")
    public String getplace()
    {
        return  "Sucesss";
    }


}
