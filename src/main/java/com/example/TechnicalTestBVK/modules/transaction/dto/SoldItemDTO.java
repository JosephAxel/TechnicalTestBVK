package com.example.TechnicalTestBVK.modules.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoldItemDTO {
    private Integer buyQuantity;
    private Double sellPrice;
    private String name;
}
