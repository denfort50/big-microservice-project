package ru.dkalchenko.catalogue.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.dkalchenko.catalogue.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(name = "Product.findAllByTitleLikeIgnoreCase")
    Iterable<Product> findAllByTitleLikeIgnoreCase(@Param("filter") String title);
}
