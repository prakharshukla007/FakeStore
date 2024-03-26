package com.scaler.productservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category {

    private long id;
    private String title;

    public Category(String title) {
        this.title = title;
    }

}
