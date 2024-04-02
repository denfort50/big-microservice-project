package ru.dkalchenko.manager.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import ru.dkalchenko.manager.dto.ProductDto;
import ru.dkalchenko.manager.exception.BadRequestException;
import ru.dkalchenko.manager.model.Product;
import ru.dkalchenko.manager.service.ProductService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Модульные тесты ProductsController")
class ProductsControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductsController productsController;

    @Test
    public void whenCreateProductThenSuccess() {
        // given
        var payload = new ProductDto("Продукт", "Детали");
        var httpServletResponse = new MockHttpServletResponse();
        var model = new ConcurrentModel();

        // when
        when(productService.createProduct(payload)).thenReturn(new Product(1, "Продукт", "Детали"));
        var result = productsController.createProduct(payload, httpServletResponse, model);
        // then
        assertThat(result).isEqualTo("redirect:/catalogue/products/1");

        verify(productService).createProduct(payload);
        verifyNoMoreInteractions(productService);
    }

    @Test
    public void whenCreateProductThenFail() {
        // given
        var payload = new ProductDto(null, "Детали");
        var httpServletResponse = new MockHttpServletResponse();
        var model = new ConcurrentModel();

        // when
        when(productService.createProduct(payload)).thenThrow(new BadRequestException(List.of("Ошибка 1", "Ошибка 2")));
        var result = productsController.createProduct(payload, httpServletResponse, model);
        // then
        assertThat(result).isEqualTo("catalogue/products/new_product");
        assertThat(payload).isEqualTo(model.getAttribute("payload"));
        assertThat(List.of("Ошибка 1", "Ошибка 2")).isEqualTo(model.getAttribute("errors"));

        verify(productService).createProduct(payload);
        verifyNoMoreInteractions(productService);
    }

}
