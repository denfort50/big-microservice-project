package ru.dkalchenko.catalogue.service;

import ru.dkalchenko.catalogue.dto.ProductDto;
import ru.dkalchenko.catalogue.model.Product;

import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAllProducts(String filter);

    Product createProduct(ProductDto request);

    Optional<Product> findProduct(Integer productId);

    void updateProduct(Integer id, String title, String details);

    void deleteProduct(Integer id);
}
