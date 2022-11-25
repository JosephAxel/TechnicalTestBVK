package com.example.TechnicalTestBVK.modules.cart.repository;

import com.example.TechnicalTestBVK.modules.cart.data.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CartRepository extends JpaRepository<CartEntity, Integer>, JpaSpecificationExecutor<CartEntity> {

}
