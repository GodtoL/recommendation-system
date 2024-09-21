package com.matching_system.inventory.Persistence;

import com.matching_system.inventory.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllByCategory(String category);
}
