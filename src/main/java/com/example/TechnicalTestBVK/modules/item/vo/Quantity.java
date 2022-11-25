package com.example.TechnicalTestBVK.modules.item.vo;
import com.example.TechnicalTestBVK.exception.ValidationException;
import com.example.TechnicalTestBVK.exception.ValidationExceptionMessages;
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
        if (quantity <= 0){
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_VALUE_LESS_THAN.getMessage(), "quantity", 0));
        }
        this.quantity = quantity;
    }
}

