package com.example.TechnicalTestBVK.modules.item.vo;
import com.example.TechnicalTestBVK.exception.ValidationException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class Quantity {
    @Column(
            name = "quantity"
    )
    private Integer quantity;

    public Quantity(Integer quantity) throws ValidationException {
        this.quantity = quantity;
    }
}

