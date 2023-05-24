package ru.anton.springinactionbootmvc.services;

import org.springframework.stereotype.Service;
import ru.anton.springinactionbootmvc.models.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> findAll() {
        return productList;
    }
}
