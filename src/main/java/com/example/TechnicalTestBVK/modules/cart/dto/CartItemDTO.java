package com.example.TechnicalTestBVK.modules.cart.dto;

import com.example.TechnicalTestBVK.modules.item.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartItemDTO {
    private Integer id;
    private Integer buyQuantity;
    private Double sellPrice;
    private ItemDTO item;
}
