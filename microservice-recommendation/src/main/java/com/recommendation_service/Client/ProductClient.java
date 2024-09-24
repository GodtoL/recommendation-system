package com.recommendation_service.Client;

import com.recommendation_service.Dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "match-inventory", url = "http://localhost:8080/api/product")
public interface ProductClient {

    @GetMapping("/search-by-category/{category}")
    List<ProductDTO> findAllproductsbyCategory(@PathVariable String category);

    @GetMapping("/{id}")
    ProductDTO findProductById(@PathVariable Long id);
}
