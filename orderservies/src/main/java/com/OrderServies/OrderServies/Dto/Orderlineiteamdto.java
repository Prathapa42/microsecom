package com.OrderServies.OrderServies.Dto;

import com.OrderServies.OrderServies.Model.OrderProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orderlineiteamdto {


    private String skcode;
    private int quantity;
    private BigDecimal price;

    @JsonIgnore
    private OrderProductdto orderProductdto;
}
