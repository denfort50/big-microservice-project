package ru.dkalchenko.catalogue.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dkalchenko.catalogue.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
