package ru.dkalchenko.manager.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.dkalchenko.manager.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = Collections.synchronizedList(new ArrayList<>());

    public InMemoryProductRepository() {
        final int max = 4;
        for (int i = 1; i < max; i++) {
            products.add(new Product(i, "Продукт №%d".formatted(i), "Детали продукта №%d".formatted(i)));
        }
    }

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Product save(Product product) {
        product.setId(products.stream()
                .max(Comparator.comparingInt(Product::getId))
                .map(Product::getId)
                .orElse(0) + 1);
        products.add(product);
        log.info("Продукт с id %d сохранён в память".formatted(product.getId()));
        return product;
    }
}
