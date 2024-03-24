package ru.dkalchenko.manager.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Integer id;

    private String title;

    private String details;
}
