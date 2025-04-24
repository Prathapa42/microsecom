package com.productservices.Productservices.ProductServies;

import com.productservices.Productservices.Dto.ProductRequest;
import com.productservices.Productservices.Dto.productResponse;
import com.productservices.Productservices.Model.Product;
import com.productservices.Productservices.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiesImpl implements ProductServies{

    private static final Logger logger = LogManager.getLogger(ProductServies.class);

    @Autowired
    private ProductRepository   productRepository;

    @Override
    public Product setproduct(ProductRequest productRequest1) {

        Product build = Product.builder().name(productRequest1.getName())
                .descption(productRequest1.getDescption())
                .price(productRequest1.getPrice()).build();
        return productRepository.save(build);
    }

    @Override
    public List<productResponse> getproduct() {
        List<Product> allProduct = productRepository.findAll();
        if(allProduct.isEmpty()){
            logger.info("No product found");
            return new ArrayList<>();
        }
        List<productResponse> collect = allProduct.stream().
                map(product -> mapToProjectResponse(product)).collect(Collectors.toList());
        return collect;

    }

    private productResponse mapToProjectResponse(Product product) {

        productResponse productRespons = productResponse.builder()
                .productid(product.getId())
                .name(product.getName())
                .descption(product.getDescption())
                .price(product.getPrice()).build();

        return  productRespons;
    }




}
