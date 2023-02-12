package com.springbootsoap.service;

import com.springbootsoap.model.Product;
import com.springbootsoap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Product getProductById(long productId) {
        Product obj = productRepository.findByProductId(productId);
        return obj;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(long productId) {
        productRepository.deleteById(productId);
    }


}
