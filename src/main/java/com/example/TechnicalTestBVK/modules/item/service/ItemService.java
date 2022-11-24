package com.example.TechnicalTestBVK.modules.item.service;

import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
import com.example.TechnicalTestBVK.modules.item.dto.ItemDTO;
import com.example.TechnicalTestBVK.modules.item.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

//    public ItemDTO save(CreateUpdateItemDTO dto) throws Exception{
//        ItemEntity newItem = new ItemEntity(dto);
//
//        return new ItemDTO(itemRepository.saveAndFlush(newItem));
//    }

    public String seed() throws Exception{
        ItemEntity item1 = new ItemEntity("makanan","biskuit enak renyah","biskuit", 50, 15000.0);
        ItemEntity item2 = new ItemEntity("makanan","bolu empuk enak","Bolu", 50, 30000.0);
        ItemEntity item3 = new ItemEntity("minuman","cairan sehat bikin segar","air mineral", 100, 5000.0);
        ItemEntity item4 = new ItemEntity("minuman","cairan baik untuk tulang","susu", 30, 10000.0);
        ItemEntity item5 = new ItemEntity("mainan","mainan yang bisa mengeluarkan air","pistol air", 50, 30000.0);
        ItemEntity item6 = new ItemEntity("mainan","mainan cowok","robot-robotan", 50, 50000.0);
        ItemEntity item7 = new ItemEntity("elektronik","alat komunikasi","Smartphone", 20, 5500000.0);
        ItemEntity item8 = new ItemEntity("elektronik","membuat udara bergerak","Kipas angin", 30, 1500000.0);

        itemRepository.saveAndFlush(item1);
        itemRepository.saveAndFlush(item2);
        itemRepository.saveAndFlush(item3);
        itemRepository.saveAndFlush(item4);
        itemRepository.saveAndFlush(item5);
        itemRepository.saveAndFlush(item6);
        itemRepository.saveAndFlush(item7);
        itemRepository.saveAndFlush(item8);

        return "seed berhasil";
    }
    public ItemDTO get(ItemEntity item) throws Exception{
        return new ItemDTO(item);
    }

    public List<ItemDTO> find(Specification<ItemEntity> specs) throws Exception{
        List<ItemEntity> items = itemRepository.findAll(specs);
        return items
                .stream()
                .map(entity -> {
                    ItemDTO dto = new ItemDTO(entity);
                    return dto;
                }).collect(Collectors.toList());
    }

    public ItemDTO update(ItemEntity updatedItem) throws Exception{
        return new ItemDTO(itemRepository.saveAndFlush(updatedItem));
    }

    public ItemDTO delete(ItemEntity item) throws Exception{
        itemRepository.delete(item);
        return new ItemDTO(item);
    }
}
