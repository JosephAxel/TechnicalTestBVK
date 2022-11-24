package com.example.TechnicalTestBVK.modules.item.controller;

import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
import com.example.TechnicalTestBVK.modules.item.dto.ItemDTO;
import com.example.TechnicalTestBVK.modules.item.service.ItemService;
import com.sipios.springsearch.anotation.SearchSpec;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/seed")
    public String get(
    ) throws Exception{
        return itemService.seed();
    }

    @GetMapping("/{id}")
    public ItemDTO get(
            @PathVariable("id") ItemEntity item
    ) throws Exception{
        return itemService.get(item);
    }

    @GetMapping()
    public List<ItemDTO> find(
            @SearchSpec Specification<ItemEntity> specs
    ) throws Exception{
        return itemService.find(specs);
    }
}
