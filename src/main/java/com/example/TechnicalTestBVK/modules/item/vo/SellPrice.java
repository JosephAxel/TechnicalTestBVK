package com.example.TechnicalTestBVK.modules.item.vo;
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
        this.sellPrice = sellPrice;
    }
}
