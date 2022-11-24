package com.example.TechnicalTestBVK.modules.cart.controller;

import com.example.TechnicalTestBVK.modules.cart.data.CartEntity;
import com.example.TechnicalTestBVK.modules.cart.dto.CartDTO;
import com.example.TechnicalTestBVK.modules.cart.dto.CreateCartDTO;
import com.example.TechnicalTestBVK.modules.cart.service.CartService;
import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
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

//    1 here usually is an id but since i hardcoded it on service it doesn't matter
    @GetMapping("/1")
    public CartDTO find() throws Exception{
        return cartService.getCartItem();
    }

//    @Transactional
//    @PutMapping("/customers/{userId}")
//    public CartDTO update(
//            @PathVariable("userId") CustomerEntity customer,
//            @RequestBody List<UpdateCartItemDTO> dtos
//    ) throws Exception{
//        return cartService.update(dtos, customer);
//    }

    @Transactional
    @DeleteMapping("/1")
    public CartDTO deleteAll() throws Exception{
        return cartService.deleteAll();
    }

    @Transactional
    @DeleteMapping("/1/item/{id}")
    public CartDTO deleteOneItem(@PathVariable("id") ItemEntity item) throws Exception{
        return cartService.deleteOneItem(item);
    }
}
