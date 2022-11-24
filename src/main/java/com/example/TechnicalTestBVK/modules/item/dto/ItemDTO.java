package com.example.TechnicalTestBVK.modules.item.dto;

import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
    private Integer id;
    private String category;
    private String description;
    private String name;
    private Integer quantity;
    private Double sellPrice;

    public ItemDTO(ItemEntity entity){
        if(entity == null) return;

        id = entity.getId();
        category = entity.getCategory().getCategory();
        description = entity.getDescription().getDescription();
        name = entity.getName().getName();
        quantity = entity.getQuantity().getQuantity();
        sellPrice = entity.getSellPrice().getSellPrice();
    }
}
