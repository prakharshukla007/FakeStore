package com.scaler.productservice.models;

import com.scaler.productservice.dtos.Rating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private long id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;
    private Rating rating;

}
