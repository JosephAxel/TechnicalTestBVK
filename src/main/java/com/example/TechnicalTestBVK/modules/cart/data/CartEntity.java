package com.example.TechnicalTestBVK.modules.cart.data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "carts")
@SequenceGenerator(name = "cart_gen", sequenceName = "cart_id_gen", allocationSize = 1)
public class CartEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_gen"
    )
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "cart")
    private List<CartItemEntity> items;

}
