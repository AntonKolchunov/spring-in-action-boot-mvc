package ru.anton.springinactionbootmvc.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope()
public class Product {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
