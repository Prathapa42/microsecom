package com.inventoryServies.inventoryServies.Repository;

import com.inventoryServies.inventoryServies.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository  extends JpaRepository<Inventory, Long> {


    public List<Inventory> findBySkcodIn(List<String> skcod);

}
