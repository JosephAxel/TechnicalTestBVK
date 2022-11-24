package com.example.TechnicalTestBVK.modules.cart.data;

import com.example.TechnicalTestBVK.modules.item.data.ItemEntity;
import com.example.TechnicalTestBVK.modules.item.vo.Quantity;
import com.example.TechnicalTestBVK.modules.item.vo.SellPrice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cart_items")
@SequenceGenerator(name = "cart_items_gen", sequenceName = "cart_items_id_gen", allocationSize = 1)
public class CartItemEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_items_gen"
    )
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    @Embedded
    private Quantity buyQuantity;

    @Embedded
    private SellPrice sellPrice;

    public CartItemEntity(CartEntity cart, ItemEntity item, Integer quantity) throws Exception{
        this.cart = cart;
        this.item = item;
        this.buyQuantity = new Quantity(quantity);
        this.sellPrice = new SellPrice(item.getSellPrice().getSellPrice());
    }
}
