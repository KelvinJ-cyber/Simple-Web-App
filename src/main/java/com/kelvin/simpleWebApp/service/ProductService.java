package com.kelvin.simpleWebApp.service;

import com.kelvin.simpleWebApp.model.Product;
import com.kelvin.simpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101, "Product A", 100),
//            new Product(102, "Product B", 200),
//            new Product(103, "Product C", 300)));

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int productId) {

        return repo.findById(productId).orElse(new Product());

    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void updateProduct(Product product) {
         repo.save(product);
    }

    public void deleteProduct(int productId) {
        repo.deleteById(productId);
    }
}
