package com.productservices.Productservices.Controller;

import com.productservices.Productservices.Dto.ProductRequest;
import com.productservices.Productservices.Dto.productResponse;
import com.productservices.Productservices.Model.Product;
import com.productservices.Productservices.ProductServies.ProductServies;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Tag(name = "Product Management", description = "API for managing products Read update delete")
public class ProductController {

    private static final Logger logger = LogManager.getLogger(ProductController.class);


    @Autowired
    private ProductServies productService;

    @PostMapping("/save/product")
    @Operation(summary = "Create a new product")
    public ResponseEntity<?> setproduct(@RequestBody ProductRequest productRequest) {


        Product setproduct = productService.setproduct(productRequest);
//           log.info("set product request {}", productRequest);
        return new ResponseEntity<>(setproduct, HttpStatus.CREATED);
    }


    @GetMapping("/get/product")
    @Operation(summary = "Get all products")
    public ResponseEntity<?> getproduct() {
        List<productResponse> getproduct = productService.getproduct();
        return new ResponseEntity<>(getproduct, HttpStatus.OK);
    }


}