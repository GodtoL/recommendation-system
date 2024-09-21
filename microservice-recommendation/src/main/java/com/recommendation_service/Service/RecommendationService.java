package com.recommendation_service.Service;

import com.recommendation_service.Dto.ProductDTO;
import com.recommendation_service.Dto.PurchaseDTO;
import com.recommendation_service.Dto.UserDTO;
import feign.Client;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public String matching(ProductDTO product, UserDTO user, PurchaseDTO purchase){
        String nameUser = user.getName();
        String nameProduct = product.getName();
        Long id = purchase.getProductId();

        return nameUser;
    }
}
