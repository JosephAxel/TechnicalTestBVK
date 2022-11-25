package com.example.TechnicalTestBVK.modules.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutDTO {
    private Integer totalItem;
    private Float totalPrice;
    private List<SoldItemDTO> soldItems;
}
