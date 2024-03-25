package ru.dkalchenko.manager.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.dkalchenko.manager.dto.ProductDto;
import ru.dkalchenko.manager.exception.BadRequestException;
import ru.dkalchenko.manager.model.Product;
import ru.dkalchenko.manager.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/catalogue/products")
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/list")
    public String getProductList(Model model, @RequestParam(name = "filter", required = false) String filter) {
        model.addAttribute("products", productService.findAll(filter));
        model.addAttribute("filter", filter);
        return "catalogue/products/list";
    }

    @GetMapping("/create")
    public String getNewProductPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("/create")
    public String createProduct(ProductDto payload, HttpServletResponse response, Model model) {
        try {
            Product product = productService.createProduct(payload);
            return "redirect:/catalogue/products/%d".formatted(product.id());
        } catch (BadRequestException exception) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            model.addAttribute("payload", payload);
            model.addAttribute("errors", exception.getErrors());
            return "catalogue/products/new_product";
        }
    }
}
