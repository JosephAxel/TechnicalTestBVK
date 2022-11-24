package com.example.TechnicalTestBVK.modules.cart.controller;

import com.example.TechnicalTestBVK.modules.cart.dto.CartDTO;
import com.example.TechnicalTestBVK.modules.cart.dto.CreateCartDTO;
import com.example.TechnicalTestBVK.modules.cart.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping()
    public CartDTO save(
            @RequestBody CreateCartDTO dto
    ) throws Exception{
        return cartService.save(dto);
    }

//    @GetMapping("/customers/{userId}")
//    public CartDTO find(
//            @PathVariable("userId") CustomerEntity customer
//    ) throws Exception{
//        return cartService.getCartItem(customer);
//    }

//    @Transactional
//    @PutMapping("/customers/{userId}")
//    public CartDTO update(
//            @PathVariable("userId") CustomerEntity customer,
//            @RequestBody List<UpdateCartItemDTO> dtos
//    ) throws Exception{
//        return cartService.update(dtos, customer);
//    }

//    @Transactional
//    @DeleteMapping("{id}")
//    public CartDTO delete(
//            @PathVariable("id") CartEntity cart
//    ) throws Exception{
//        return cartService.delete(cart);
//    }
}
