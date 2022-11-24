package com.example.TechnicalTestBVK.modules.cart.vo;

import com.example.TechnicalTestBVK.exception.ValidationException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class TotalItem {
    @Column(
            name = "total_item"
    )
    private Integer totalItem;

    public TotalItem(Integer totalItem) throws ValidationException {
        this.totalItem = totalItem;
    }
}
