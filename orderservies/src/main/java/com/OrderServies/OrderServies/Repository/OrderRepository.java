package com.OrderServies.OrderServies.Repository;

import com.OrderServies.OrderServies.Model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository <OrderProduct,Long>{

}
