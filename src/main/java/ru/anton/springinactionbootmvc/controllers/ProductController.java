package ru.anton.springinactionbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.anton.springinactionbootmvc.models.Product;
import ru.anton.springinactionbootmvc.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String viewProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products.html";
    }

    @PostMapping()
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") double price,
                             Model model) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.add(product);

        return "redirect:/products";
    }
}
