package com.example.jwt_restful_api.service;

import com.example.jwt_restful_api.entity.Product;
import com.example.jwt_restful_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public Product addProduct(Product product) {
        product.setId(0);
        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product updateProduct(Product product) {
        return repo.save(product);
    }

    public void deleteProductById(int id) {
        repo.deleteById(id);
    }

}
