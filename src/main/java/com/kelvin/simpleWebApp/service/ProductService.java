package com.kelvin.simpleWebApp.service;

import com.kelvin.simpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Product A", 100),
            new Product(102, "Product B", 200),
            new Product(103, "Product C", 300)));

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int productId) {

        return products.stream()
                .filter(p -> p.getProductId() == productId)
                .findFirst().get();

    }

    public void addProduct(Product prod){
        products.add(prod);
    }

}
