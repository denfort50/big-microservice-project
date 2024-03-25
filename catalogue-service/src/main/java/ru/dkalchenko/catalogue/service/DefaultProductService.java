package ru.dkalchenko.catalogue.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    public Iterable<Product> findAllProducts(String filter) {
        if (filter != null && !filter.isBlank()) {
            return productRepository.findAllByTitleLikeIgnoreCase("%" + filter + "%");
        } else {
            return productRepository.findAll();
        }
    }

    @Override
    @Transactional
    public Product createProduct(ProductDto request) {
        return productRepository.save(new Product(null, request.title(), request.details()));
    }

    @Override
    public Optional<Product> findProduct(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    @Transactional
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
    @Transactional
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
