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

    // ! @RequestBody annotation is used to map the HTTP request body to a Java object
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
    }


    @DeleteMapping("/products/{productId}") // ! Path variable to capture productId from the URL and store it in the productId parameter
    public void deleteProduct(@PathVariable int productId) {
        service.deleteProduct(productId);
    }
    public void method() {
        // This method is intentionally left blank
    }
}
