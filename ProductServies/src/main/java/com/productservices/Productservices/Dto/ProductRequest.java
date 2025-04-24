package com.productservices.Productservices.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Setter
@Getter

//@Schema(description = "Product Request DTO")
public class ProductRequest {

    @JsonProperty("name")
    @NotEmpty
    @Schema(description = "Product Name")
    private String name;
    @JsonProperty("descption")
    private String descption;
    @JsonProperty("price")
    private BigDecimal price;



}
