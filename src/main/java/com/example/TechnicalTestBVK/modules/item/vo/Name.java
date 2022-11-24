package com.example.TechnicalTestBVK.modules.item.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import com.example.TechnicalTestBVK.exception.ValidationException;
@Embeddable
@Getter
@NoArgsConstructor
public class Name {
    @Column(
            name = "name"
    )
    private String name;

    public Name(String name) throws ValidationException {
        this.name = name;
    }
}
