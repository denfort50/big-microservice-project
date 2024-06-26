package ru.dkalchenko.catalogue.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "catalogue", name = "products")
@NamedQueries(
        @NamedQuery(name = "Product.findAllByTitleLikeIgnoreCase",
                query = "select p from Product p where p.title ilike :filter"
        )
)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50)
    private String title;

    @Size(max = 1000)
    private String details;
}
