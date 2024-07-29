package com.JERZ.GroceryGurus.service;

import org.springframework.stereotype.Service;

import com.JERZ.GroceryGurus.entity.Product;
import com.JERZ.GroceryGurus.repository.ProductRepository;

import java.util.Optional;
import java.util.List;
@Service
public class ProductService {
    
    private ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Integer id) {
        Optional<Product> optProduct = productRepository.findById(id);
        return optProduct.orElse(null);
    }

    public void create(Product p) {
        this.productRepository.save(p);
    }

    public Product update(Product p, Integer id) {
        Optional<Product> optProduct = this.productRepository.findById(id);
        if(!optProduct.isPresent()) return null;
        Product product = optProduct.get();
        if (p.getName() != null) {
            product.setName(p.getName());
        }
        if (p.getPrice() != null) {
            product.setPrice(p.getPrice());
        }
        if (p.getQuantity() != null) {
            product.setQuantity(p.getQuantity());
        }
        if (p.getDepartment() != null) {
            product.setDepartment(p.getDepartment());
        }
        if (p.getDescription() != null) {
            product.setDescription(p.getDescription());
        }
        return productRepository.save(product);
    }

    public void delete(Integer id) {
        this.productRepository.deleteById(id);
    }
}
