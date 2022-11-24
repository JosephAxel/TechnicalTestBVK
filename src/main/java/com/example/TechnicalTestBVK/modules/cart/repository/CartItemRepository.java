package com.example.TechnicalTestBVK.modules.cart.repository;

import com.example.TechnicalTestBVK.modules.cart.data.CartEntity;
import com.example.TechnicalTestBVK.modules.cart.data.CartItemEntity;
import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Integer>, JpaSpecificationExecutor<CartItemEntity> {
    List<CartItemEntity> findByCart(CartEntity cart);

    boolean existsByCartAndItem(CartEntity cart, ItemEntity item);

    CartItemEntity findByCartAndItem(CartEntity cart, ItemEntity item);

    long deleteByCart(CartEntity cart);

    long deleteByCartAndItem(CartEntity cart, ItemEntity item);



}
