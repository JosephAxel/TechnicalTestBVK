package com.example.TechnicalTestBVK.modules.item.vo;
import com.example.TechnicalTestBVK.exception.ValidationException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class Description {
    @Column(
            name = "description"
    )
    private String description;

    public Description(String description) throws ValidationException {
        this.description = description;
    }
}
