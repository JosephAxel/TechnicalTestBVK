package com.example.TechnicalTestBVK.modules.cart.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateCartDTO {
    private List<BuyItemDTO> items;
}
