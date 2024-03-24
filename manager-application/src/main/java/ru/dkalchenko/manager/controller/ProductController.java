package ru.dkalchenko.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dkalchenko.manager.model.NewProductRequest;
import ru.dkalchenko.manager.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/catalogue/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/list")
    public String getProductList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "catalogue/products/list";
    }

    @GetMapping("/create")
    public String getNewProductPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("/create")
    public String createProduct(NewProductRequest newProductRequest) {
        productService.createProduct(newProductRequest);
        return "redirect:/catalogue/products/list";
    }
}
