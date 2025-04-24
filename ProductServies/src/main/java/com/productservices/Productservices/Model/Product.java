package com.productservices.Productservices.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@Entity
@Setter
@Getter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "product_id")
  public Long id;
  @Column(name = "product_name"  ,  nullable = false, length = 100)
  public String name;
  @Column(name = "product_description", nullable = false, length = 200)
  public String descption;
  @Column(name = "product_price"    ,  nullable = false)
  public BigDecimal price;



}
