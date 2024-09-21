package com.recommendation_service.Controller;

import com.recommendation_service.Dto.ProductDTO;
import com.recommendation_service.Dto.PurchaseDTO;
import com.recommendation_service.Dto.UserDTO;
import com.recommendation_service.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommend-product")
public class RecommendController {
    @Autowired
    RecommendationService recommendationService;

    @GetMapping()
    public String matching(@RequestBody ProductDTO product, @RequestBody UserDTO user, @RequestBody PurchaseDTO purchase){
        return recommendationService.matching(product, user, purchase);
    }
}
