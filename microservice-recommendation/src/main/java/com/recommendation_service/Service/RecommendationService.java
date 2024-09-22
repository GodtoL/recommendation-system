package com.recommendation_service.Service;

import com.recommendation_service.Client.ProductClient;
import com.recommendation_service.Client.PurchaseClient;
import com.recommendation_service.Client.UserClient;
import com.recommendation_service.Dto.ProductDTO;
import com.recommendation_service.Dto.PurchaseDTO;
import com.recommendation_service.Dto.UserDTO;
import feign.Client;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final ProductClient productClient;

    @Autowired
    public RecommendationService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public List<ProductDTO> matching(String category){
        return productClient.findAllproductsbyCategory(category);

    }
/*
    public String matching(Long userId) {
        UserClient user = userClient.getUserProfileById(userId);
        PurchaseClient purchase = purchase
        return user.getName();
    }*/
}
