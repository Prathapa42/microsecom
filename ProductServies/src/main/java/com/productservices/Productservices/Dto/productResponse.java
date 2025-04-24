package com.productservices.Productservices.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class productResponse {

    @JsonProperty("productid")
    private Long productid;
    @JsonProperty("productname")

    private String name;
    @JsonProperty("productcategory")
    private String descption;
    @JsonProperty("productprice")
    private BigDecimal price;

}
