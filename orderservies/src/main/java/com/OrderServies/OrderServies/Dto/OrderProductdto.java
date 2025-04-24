package com.OrderServies.OrderServies.Dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

public class OrderProductdto {



    private Long orderNumber;
    private List<Orderlineiteamdto> Orderlineiteamdto;
}
