package com.example.TechnicalTestBVK.modules.cart.service;

import com.example.TechnicalTestBVK.modules.cart.data.CartEntity;
import com.example.TechnicalTestBVK.modules.cart.data.CartItemEntity;
import com.example.TechnicalTestBVK.modules.cart.dto.BuyItemDTO;
import com.example.TechnicalTestBVK.modules.cart.dto.CartDTO;
import com.example.TechnicalTestBVK.modules.cart.dto.CartItemDTO;
import com.example.TechnicalTestBVK.modules.cart.dto.CreateCartDTO;
import com.example.TechnicalTestBVK.modules.cart.repository.CartItemRepository;
import com.example.TechnicalTestBVK.modules.cart.repository.CartRepository;
import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
import com.example.TechnicalTestBVK.modules.item.dto.ItemDTO;
import com.example.TechnicalTestBVK.modules.item.repository.ItemRepository;
import com.example.TechnicalTestBVK.modules.item.vo.Quantity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;
    private final CartItemRepository cartItemRepository;

    public CartDTO getCartItem() throws Exception{
//      i hardcoded the cart id by 1 for this technical test purpose only
        CartEntity cart = cartRepository.findById(1).orElse(null);
//      this is for init the cart if there is no cart founded in the database
        if (cart == null){
            cart = cartRepository.saveAndFlush(new CartEntity());
        }

        List<CartItemEntity> cartItems = cartItemRepository.findByCart(cart);
        List<CartItemDTO> cartItemDTOS = new ArrayList<>();
        Integer totalItem = 0;
        Float totalPrice = 0f;

        for (CartItemEntity cartItem : cartItems){
            ItemDTO itemDTO = new ItemDTO(cartItem.getItem());
            CartItemDTO cartItemDTO = new CartItemDTO(
                    cartItem.getId(),
                    cartItem.getBuyQuantity().getQuantity(),
                    cartItem.getSellPrice().getSellPrice(),
                    itemDTO);

            cartItemDTOS.add(cartItemDTO);
            totalItem += cartItemDTO.getBuyQuantity();
            totalPrice += cartItemDTO.getBuyQuantity().floatValue() * cartItemDTO.getSellPrice().floatValue();
        }

        return new CartDTO(cart.getId(), totalItem, totalPrice, cartItemDTOS);
    }

    public CartDTO save(CreateCartDTO dto) throws Exception{
//      i hardcoded the cart id by 1 for this technical test purpose only
        CartEntity cart = cartRepository.findById(1).orElse(null);
//      this is for init the cart if there is no cart founded in the database
        if (cart == null){
            cart = cartRepository.saveAndFlush(new CartEntity());
        }

        List<CartItemEntity> cartItems = cartItemRepository.findByCart(cart);
        List<CartItemDTO> cartItemDTOS = new ArrayList<>();
        Integer totalItem = 0;
        Float totalPrice = 0f;

        for (BuyItemDTO buyItemDTO: dto.getItems()) {
            ItemEntity item = itemRepository.getById(buyItemDTO.getItemId());
            CartItemEntity cartItem = cartItemRepository.findByCartAndItem(cart, item);

            Integer totalItemQuantity = 0;
            if (cartItem != null){
                totalItemQuantity = cartItem.getBuyQuantity().getQuantity();
            }
            totalItemQuantity += buyItemDTO.getQuantity();
            if (buyItemDTO.getQuantity() > item.getQuantity().getQuantity() || totalItemQuantity > item.getQuantity().getQuantity()){
                throw new Exception("Purchase quantity exceeds inventory item quantity");
            }

//          condition for case when you already have the item in your cart then you just need to update the quantity
            if (cartItemRepository.existsByCartAndItem(cart, item)){
                cartItem.setBuyQuantity(new Quantity(totalItemQuantity));
                cartItemRepository.saveAndFlush(cartItem);
            }else{
                cartItem = new CartItemEntity(cart, item, buyItemDTO.getQuantity());
                cartItems.add(cartItem);
            }
        }

        cartItemRepository.saveAllAndFlush(cartItems);

//      mapping to dtos and calculate temporary total price and qty items for return
        for (CartItemEntity cartItem : cartItems){
            ItemDTO itemDTO = new ItemDTO(cartItem.getItem());
            CartItemDTO cartItemDTO = new CartItemDTO(cartItem.getId(), cartItem.getBuyQuantity().getQuantity(), cartItem.getSellPrice().getSellPrice(), itemDTO);
            cartItemDTOS.add(cartItemDTO);
            totalItem += cartItemDTO.getBuyQuantity();
            totalPrice += cartItemDTO.getBuyQuantity().floatValue() * cartItemDTO.getSellPrice().floatValue();
        }

        cart.setItems(cartItems);
        cartRepository.saveAndFlush(cart);
        return new CartDTO(cart.getId(), totalItem, totalPrice, cartItemDTOS);
    }

    public CartDTO deleteAll() throws Exception{
        CartEntity cart = cartRepository.getById(1);
        cartItemRepository.deleteByCart(cart);
        return getCartItem();
    }

    public CartDTO deleteOneItem(ItemEntity item) throws Exception{
        CartEntity cart = cartRepository.getById(1);
        cartItemRepository.deleteByCartAndItem(cart, item);
        return getCartItem();
    }
}
