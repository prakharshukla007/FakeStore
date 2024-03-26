package com.scaler.productservice.dtos;

import com.scaler.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {

    private long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;
    private Rating rating;

}
