package ru.dkalchenko.manager.service;

import ru.dkalchenko.manager.model.NewProductRequest;
import ru.dkalchenko.manager.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product createProduct(NewProductRequest newProductRequest);
}
