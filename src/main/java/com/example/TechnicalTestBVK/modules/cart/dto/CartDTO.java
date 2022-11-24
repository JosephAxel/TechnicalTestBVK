package com.example.TechnicalTestBVK.modules.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Integer id;
    private Integer totalItem;
    private Float totalPrice;
    private List<CartItemDTO> cartItems;
}
