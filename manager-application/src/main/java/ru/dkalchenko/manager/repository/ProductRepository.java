package ru.dkalchenko.manager.repository;

import ru.dkalchenko.manager.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product save(Product product);
}
