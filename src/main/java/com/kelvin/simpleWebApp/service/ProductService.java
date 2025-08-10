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

    public void updateProduct(Product product) {
        int index = 0;
        for(Product p : products){
            if(p.getProductId() == product.getProductId()){
                products.set(index, product);
                return;
            }
            index++;
        }
    }

    public void deleteProduct(int productId) {
        int index = 0;
        for(Product p : products){
            if(p.getProductId() == productId){
                products.remove(index);
                return;
            }
            index++;
        }
    }
}
