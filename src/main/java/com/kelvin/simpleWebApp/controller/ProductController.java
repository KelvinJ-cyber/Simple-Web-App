package com.kelvin.simpleWebApp.controller;


import com.kelvin.simpleWebApp.model.Product;
import com.kelvin.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;


    @GetMapping("/products")
    public List<Product> getProduct() {
        return service.getAllProducts();
    }

    @GetMapping("/products/{productId}") // ! Path variable to capture productId from the URL and store it in the productId parameter
    public Product getProductById( @PathVariable int productId){
        return service.getProductById(productId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product);
        service.addProduct(product);
    }
}
