package com.example.TechnicalTestBVK.modules.transaction.service;

import com.example.TechnicalTestBVK.modules.cart.data.CartEntity;
import com.example.TechnicalTestBVK.modules.cart.data.CartItemEntity;
import com.example.TechnicalTestBVK.modules.cart.dto.CartDTO;
import com.example.TechnicalTestBVK.modules.cart.dto.CartItemDTO;
import com.example.TechnicalTestBVK.modules.cart.repository.CartItemRepository;
import com.example.TechnicalTestBVK.modules.cart.repository.CartRepository;
import com.example.TechnicalTestBVK.modules.cart.service.CartService;
import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
import com.example.TechnicalTestBVK.modules.item.dto.ItemDTO;
import com.example.TechnicalTestBVK.modules.item.repository.ItemRepository;
import com.example.TechnicalTestBVK.modules.item.service.ItemService;
import com.example.TechnicalTestBVK.modules.item.vo.Quantity;
import com.example.TechnicalTestBVK.modules.transaction.dto.CheckoutDTO;
import com.example.TechnicalTestBVK.modules.transaction.dto.SoldItemDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final ItemService itemService;
    private final CartService cartService;

    public CheckoutDTO checkout(Integer cartId) throws Exception{
//      i hardcoded the cart id by 1 for this technical test purpose only
        CartEntity cart = cartRepository.findById(1).orElse(null);
//      this is for init the cart if there is no cart founded in the database
        if (cart == null){
            cart = cartRepository.saveAndFlush(new CartEntity());
            return null;
        }

        CartDTO cartDTO = cartService.getCartItem();
        List<SoldItemDTO> soldItemDTOS = new ArrayList<>();

        for (CartItemDTO cartItemDTO: cartDTO.getCartItems()) {
            SoldItemDTO soldItemDTO = new SoldItemDTO(cartItemDTO.getBuyQuantity(),
                    cartItemDTO.getSellPrice(),
                    cartItemDTO.getItem().getName());
            soldItemDTOS.add(soldItemDTO);

            ItemEntity item = itemRepository.getById(cartItemDTO.getItem().getId());
            Integer newQuantity = item.getQuantity().getQuantity() - cartItemDTO.getBuyQuantity();
            item.setQuantity(new Quantity(newQuantity));
            itemService.update(item);
        }

        cartService.deleteAll();
        return new CheckoutDTO(cartDTO.getTotalItem(), cartDTO.getTotalPrice(), soldItemDTOS);
    }


}
