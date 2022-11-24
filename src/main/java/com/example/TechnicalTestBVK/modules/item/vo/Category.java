package com.example.TechnicalTestBVK.modules.item.vo;

import com.example.TechnicalTestBVK.exception.ValidationException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class Category {
    @Column(
            name = "category"
    )
    private String category;

    public Category(String category) throws ValidationException {
        this.category = category;
    }
}
