package com.springbootsoap.service;

import com.springbootsoap.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(long productId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(long productId);
}
