package com.JERZ.GroceryGurus.controller;

import com.JERZ.GroceryGurus.entity.Product;
import com.JERZ.GroceryGurus.service.ProductService;    

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ProductController {
    
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = this.productService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
        Product product = this.productService.findById(id);
        if(product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product p) {
        this.productService.create(p);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") Integer id) {
        Product product = this.productService.findById(id);
        if(product == null) {
            return ResponseEntity.notFound().build(); 
        }
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Integer id, @RequestBody Product p) {
        Product updatedProduct = this.productService.update(p, id);
        if(updatedProduct != null) return ResponseEntity.ok(updatedProduct);
        return ResponseEntity.notFound().build();
    }
}
