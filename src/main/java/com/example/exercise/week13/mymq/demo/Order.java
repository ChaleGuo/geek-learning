package com.example.exercise.week13.mymq.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    private Long id;
    private Long ts;
    private String symbol;
    private Double price;

}