package com.inventoryServies.inventoryServies.Servies;

import com.inventoryServies.inventoryServies.Dto.InventoryDto;
import com.inventoryServies.inventoryServies.Dto.InventoryResponesCkeck;
import com.inventoryServies.inventoryServies.Dto.InventoryResponse;
import com.inventoryServies.inventoryServies.Model.Inventory;
import com.inventoryServies.inventoryServies.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service

public class InventoryServiesImpl implements  InventoryServies {

     @Autowired
     private InventoryRepository inventoryRepository;

    @Override
    public InventoryResponse setInventory(InventoryDto inventoryDto) {

        Inventory inventory = getinventoryDto(inventoryDto);
        inventoryRepository.save(inventory);
        InventoryResponse inventoryResponse = setInveroryRespnse(inventory);
        return inventoryResponse;
    }

    @Override
    public List<InventoryResponesCkeck> getInventory(List<String> skcod) {

        List<Inventory> byskcod = inventoryRepository. findBySkcodIn(skcod);

        List<InventoryResponesCkeck> collect = byskcod.stream()
                .map(inventoryy -> {
                    InventoryResponesCkeck inventoryResponesCkeck = new InventoryResponesCkeck(inventoryy.getQty() > 0,
                            inventoryy.getSkcod(),
                            inventoryy.getQty()
                    );
                    return inventoryResponesCkeck;

                }).collect(Collectors.toList());


        return collect;
    }

    private InventoryResponse setInveroryRespnse(Inventory inventory) {
        InventoryResponse inventoryResponse  = InventoryResponse.builder()
                .skcod(inventory.getSkcod())
                .qty(inventory.getQty()).build();
        return inventoryResponse;
    }

    private Inventory getinventoryDto(InventoryDto inventoryDto) {
        Inventory inventory = Inventory.builder()
                .skcod(inventoryDto.getSkcod())
                .qty(inventoryDto.getQty()).build();
        return   inventory;
    }


}
