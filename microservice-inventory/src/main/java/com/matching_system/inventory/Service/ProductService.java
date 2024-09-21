package com.matching_system.inventory.Service;

import com.matching_system.inventory.Models.Product;
import com.matching_system.inventory.Persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById( Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con el id " + id));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getProductByCategory(String category){
        List<Product> products = productRepository.getAllByCategory(category);
        if (products.isEmpty()){
            throw new RuntimeException("No se ha encontrado ningún producto en la categoría " + category);
        }
        return products;
    }

    public Product updateProduct(Long id, Product productDetails){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el producto con el id " + id));
        product.setName(productDetails.getName());
        product.setCategory(productDetails.getCategory());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }
}