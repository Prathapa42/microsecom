package com.OrderServies.OrderServies.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class OrderProduct {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long orderNumber;
    @OneToMany(mappedBy = "orderproduct"  , cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Orderlineiteam> Orderlineiteam;
}
