package com.recommendation_service.Service;

import com.recommendation_service.Dto.ProductDTO;
import com.recommendation_service.Dto.PurchaseDTO;
import com.recommendation_service.Dto.UserDTO;
import feign.Client;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public void matching(ProductDTO product, UserDTO user, PurchaseDTO purchase){
        System.out.println(user.getName());
        System.out.println(purchase.getProductId());
        System.out.println(product.getName());
    }
}
