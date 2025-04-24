package com.inventoryServies.inventoryServies.Servies;

import com.inventoryServies.inventoryServies.Dto.InventoryDto;
import com.inventoryServies.inventoryServies.Dto.InventoryResponesCkeck;
import com.inventoryServies.inventoryServies.Dto.InventoryResponse;

import java.util.List;

public interface InventoryServies {


      public InventoryResponse setInventory(InventoryDto inventoryDto);

      public List<InventoryResponesCkeck> getInventory(List<String> skcod);
}
