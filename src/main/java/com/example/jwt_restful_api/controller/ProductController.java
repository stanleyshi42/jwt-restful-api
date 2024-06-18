package com.example.jwt_restful_api.controller;

import com.example.jwt_restful_api.entity.Product;
import com.example.jwt_restful_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/product")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @GetMapping("/product")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PutMapping("/product")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteProduct(@PathVariable int id) {
        service.deleteProductById(id);
        return "Product deleted";
    }
}
