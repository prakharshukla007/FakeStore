package com.scaler.productservice.services;

import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getProductById(long id);
    List<Product> getAllProducts();

}
