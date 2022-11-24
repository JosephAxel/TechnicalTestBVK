package com.example.TechnicalTestBVK.modules.item.repository;


import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer>, JpaSpecificationExecutor<ItemEntity> {

}
