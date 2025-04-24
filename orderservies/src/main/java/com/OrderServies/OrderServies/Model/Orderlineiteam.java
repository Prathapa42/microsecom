package com.OrderServies.OrderServies.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Orderlineiteam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderlineitemId;
    private String skcode;
    private int quantity;
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private OrderProduct orderproduct;
}
