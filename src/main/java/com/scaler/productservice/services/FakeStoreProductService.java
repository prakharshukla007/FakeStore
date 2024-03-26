package com.scaler.productservice.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Product getProductById(long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return convertFromDto(fakeStoreProductDto);
    }

    public List<Product> getAllProducts() {
        List<?> response = restTemplate.getForObject("https://fakestoreapi.com/products", List.class);
        return response.stream().map(o -> objectMapper.convertValue(o, new TypeReference<FakeStoreProductDto>() {})).map(this::convertFromDto).toList();
    }

    private Product convertFromDto(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setRating(fakeStoreProductDto.getRating());

        Category category = new Category(fakeStoreProductDto.getCategory().getTitle());
        product.setCategory(category)   ;
        return product;
    }

}
