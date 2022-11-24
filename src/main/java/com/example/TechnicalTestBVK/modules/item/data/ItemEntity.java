package com.example.TechnicalTestBVK.modules.item.data;

import com.example.TechnicalTestBVK.modules.cart.data.CartItemEntity;
import com.example.TechnicalTestBVK.modules.item.vo.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "items")
@SequenceGenerator(name = "item_gen", sequenceName = "item_id_gen", allocationSize = 1)
public class ItemEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_gen"
    )
    @Column(name = "id")
    private Integer id;

    @Embedded
    private Category category;

    @Embedded
    private Description description;

    @Embedded
    private Name name;

    @Embedded
    private Quantity quantity;

    @Embedded
    private SellPrice sellPrice;

    @OneToMany(mappedBy = "item")
    private List<CartItemEntity> carts;

    public ItemEntity(
            String category,
            String description,
            String name,
            Integer quantity,
            Double sellPrice
    ) throws Exception {
        this.category = new Category(category);
        this.description = new Description(description);
        this.name = new Name(name);
        this.quantity = new Quantity(quantity);
        this.sellPrice = new SellPrice(sellPrice);
    }

}
