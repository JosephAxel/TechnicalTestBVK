package com.example.TechnicalTestBVK.modules.item.vo;
import com.example.TechnicalTestBVK.exception.ValidationExceptionMessages;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import com.example.TechnicalTestBVK.exception.ValidationException;

@Embeddable
@Getter
@NoArgsConstructor
public class SellPrice {
    @Column(
            name = "sell_price"
    )
    private Double sellPrice;

    public SellPrice(Double sellPrice) throws ValidationException {
        if (sellPrice <= 0){
            throw new ValidationException(String.format(ValidationExceptionMessages.VALIDATION_VALUE_LESS_THAN.getMessage(), "sell price", 0));
        }
        this.sellPrice = sellPrice;
    }
}
