package com.inventoryServies.inventoryServies.Contoller;

import com.inventoryServies.inventoryServies.Dto.InventoryDto;
import com.inventoryServies.inventoryServies.Dto.InventoryResponesCkeck;
import com.inventoryServies.inventoryServies.Dto.InventoryResponse;
import com.inventoryServies.inventoryServies.Servies.InventoryServies;
import com.inventoryServies.inventoryServies.Servies.InventoryServiesImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Api/inventory")

public class InventoryContoller {

       @Autowired
       private InventoryServiesImpl inventoryServic
       private String prathap;
       private;

      @Operation(description = "set inventoryitem")

       @PostMapping("/set/inventoryitem")
      public ResponseEntity<?> setInventory(@RequestBody InventoryDto InventoryDto)
      {
          InventoryResponse inventoryResponse = inventoryService.setInventory(InventoryDto);
          return  new ResponseEntity<>(inventoryResponse, HttpStatus.CREATED);
      }
      @Operation(description = "get checkInventoryitem")
    @GetMapping("/get/inventoryitem")
    public ResponseEntity<?> getInventory(@RequestParam("skcod")List<String> skcod)
      {

    	  List<InventoryResponesCkeck> inventory = inventoryService.getInventory(skcod);

          return  new  ResponseEntity<>(inventory, HttpStatus.OK);
      }
      
      
      @GetMapping("/hi")
      public String m1(@RequestParam("skc") String skc)
      {
    	  System.out.println(skc);
    	  return "hello";
      }


}
