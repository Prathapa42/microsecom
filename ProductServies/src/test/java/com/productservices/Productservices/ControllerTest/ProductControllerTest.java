package com.productservices.Productservices.ControllerTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservices.Productservices.Controller.ProductController;
import com.productservices.Productservices.Dto.ProductRequest;
import com.productservices.Productservices.Model.Product;
import com.productservices.Productservices.ProductServies.ProductServies;
import com.productservices.Productservices.Repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @MockBean
     private ProductServies productServies;
    @Autowired
    private ObjectMapper objectMapper;
    @Container
    static MySQLContainer mysql = new MySQLContainer("mysql:9.2.0");


    @DynamicPropertySource
    public  static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {

        dynamicPropertyRegistry.add("spring.datasource.url", mysql::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username", mysql::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", mysql::getPassword);
    }
    @Test
    public void ShouldCreateProduct() throws Exception {
        ProductRequest productRequest = getProductRequest();
        Product product = Product.builder().id(1L)
                 .name("Iphone").descption("Mobile").price(BigDecimal.valueOf(12000)).build();
        String requestJson = objectMapper.writeValueAsString(productRequest);
        Mockito.when(productServies.setproduct(productRequest)).thenReturn(product);;
        mockMvc.perform(MockMvcRequestBuilders.post   ("/api/product/save/product")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L)
                );

    }

    private ProductRequest getProductRequest() {
      return   ProductRequest.builder()
                .name("Iphone")
                .descption("Mobile")
                .price(BigDecimal.valueOf(12000)).build();
    }



}
