package com.inventoryServies.inventoryServies.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class InventoryResponesCkeck extends  InventoryResponse {

        private boolean isAvailable;

        public InventoryResponesCkeck(boolean isAvailable, String Skcod, int qty) {
                 super(Skcod, qty);
                this.isAvailable = isAvailable;
        }
}
