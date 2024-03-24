package ru.dkalchenko.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dkalchenko.manager.model.NewProductRequest;
import ru.dkalchenko.manager.model.Product;
import ru.dkalchenko.manager.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(NewProductRequest newProductRequest) {
        return productRepository.save(new Product(null, newProductRequest.title(), newProductRequest.details()));
    }
}
