package com.recommendation_service.Service;

import com.recommendation_service.Client.ProductClient;
import com.recommendation_service.Client.PurchaseClient;
import com.recommendation_service.Client.UserClient;
import com.recommendation_service.Dto.ProductDTO;
import com.recommendation_service.Dto.PurchaseDTO;
import com.recommendation_service.Dto.UserDTO;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;
import java.util.Random;
@Service
public class RecommendationService {

    private final ProductClient productClient;
    private final PurchaseClient purchaseClient;
    private final UserClient userClient;

    @Autowired
    public RecommendationService(ProductClient productClient, PurchaseClient purchaseClient, UserClient userClient) {
        this.productClient = productClient;
        this.purchaseClient = purchaseClient;
        this.userClient = userClient;
    }

    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackMatching")
    public String matching(Long userId) {
        // Obtenemos las compras del usuario
        UserDTO user = userClient.getUserById(userId);
        List<PurchaseDTO> purchases;

        try {
            purchases = purchaseClient.getPurchasesById(userId);
        } catch (FeignException.NotFound e) {
            return fallbackGetProducts(e); // Manejar el caso donde no se encontraron compras
        }

        if (purchases.isEmpty()) {
            return fallbackGetProducts(new RuntimeException("No se encontraron compras para el usuario " + userId));
        }

        // Obtenemos una de las compras del usuario
        Random random = new Random();
        int randomIndex = random.nextInt(purchases.size());
        PurchaseDTO nextIdRecommendation = purchases.get(randomIndex);
        Long productId = nextIdRecommendation.getProductId();

        // Buscamos el producto a recomendar
        ProductDTO product = productClient.findProductById(productId);
        List<ProductDTO> products = productClient.findAllproductsbyCategory(product.getCategory());

        if (products.isEmpty()) {
            return fallbackMatching(userId, new RuntimeException("No se encontraron productos en la categoría"));
        }

        int randomProduct = random.nextInt(products.size());
        ProductDTO nextRecommendation = products.get(randomProduct);

        return "Recomendamos al usuario " + user.getName() + " un " + nextRecommendation.getName() + " en su próxima compra";
    }
    public String fallbackGetProducts(Throwable e) {
        return "No se pueden generar recomendaciones en este momento. " + e.getMessage();
    }

    public String fallbackMatching(Long userId, Throwable e) {
        return "No se pueden generar recomendaciones en este momento. Intenta más tarde."; // Mensaje de fallback
    }
}