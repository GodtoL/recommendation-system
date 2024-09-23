package com.recommendation_service.Service;

import com.recommendation_service.Client.ProductClient;
import com.recommendation_service.Client.PurchaseClient;
import com.recommendation_service.Client.UserClient;
import com.recommendation_service.Dto.ProductDTO;
import com.recommendation_service.Dto.PurchaseDTO;
import com.recommendation_service.Dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RecommendationService {

    private final ProductClient productClient;
    private final PurchaseClient purchaseClient;
    private final UserClient userClient;
    @Autowired
    public RecommendationService(ProductClient productClient, PurchaseClient purchaseClient, UserClient userClient){
        this.productClient = productClient;
        this.purchaseClient = purchaseClient;
        this.userClient = userClient;
    }

    public String matching(Long userId){
        UserDTO user = userClient.getUserById(userId);
        List<PurchaseDTO> purchases = purchaseClient.getPurchasesById(userId);

        Random random = new Random();
        int randomIndex = random.nextInt(purchases.size());
        PurchaseDTO nextIdRecommendation = purchases.get(randomIndex);
        Long productId = nextIdRecommendation.getProductId();
        ProductDTO product = productClient.findProductById(productId);
        List<ProductDTO> products = productClient.findAllproductsbyCategory(product.getCategory());
        int randomProduct = random.nextInt(purchases.size());
        ProductDTO nextRecommendation = products.get(randomProduct);
        return "Recomendamos al usuario " + user.getName() + " un " + nextRecommendation.getName() + " en su próxima compra";
    }
/*
    public String matching(Long userId) {
        UserClient user = userClient.getUserProfileById(userId);
        PurchaseClient purchase = purchase
        return user.getName();
    }*/
}
