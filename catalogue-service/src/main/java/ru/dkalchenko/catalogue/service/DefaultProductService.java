package ru.dkalchenko.catalogue.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dkalchenko.catalogue.dto.ProductDto;
import ru.dkalchenko.catalogue.model.Product;
import ru.dkalchenko.catalogue.repository.ProductRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDto request) {
        return productRepository.save(new Product(null, request.title(), request.details()));
    }

    @Override
    public Optional<Product> findProduct(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    public void updateProduct(Integer id, String title, String details) {
        productRepository.findById(id)
                .ifPresentOrElse(product -> {
                    product.setTitle(title);
                    product.setDetails(details);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
