package edu.itc.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.itc.shop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void restock(long fromId, long toId, int qty) {
        // 1. remove from the source product
        int removed = repo.updateStock(fromId, -qty);
        if (removed == 0) {
            throw new IllegalStateException(
                "Product " + fromId + " not found or has fewer than " + qty + " units");
        }

        // 2. add to the target product
        int added = repo.updateStock(toId, qty);
        if (added == 0) {
            throw new IllegalStateException("Product " + toId + " not found");
            
        }
    }
}