package ru.dkalchenko.manager.service;

import ru.dkalchenko.manager.dto.ProductDto;
import ru.dkalchenko.manager.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll(String filter);

    Product createProduct(ProductDto request);

    Optional<Product> findProduct(Integer productId);

    void updateProduct(Integer id, ProductDto payload);

    void deleteProduct(Integer id);
}
