package com.recommendation_service.Controller;

import com.recommendation_service.Dto.ProductDTO;
import com.recommendation_service.Dto.PurchaseDTO;
import com.recommendation_service.Dto.UserDTO;
import com.recommendation_service.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommend-product")
public class RecommendController {
    @Autowired
    RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public String  matching(@PathVariable Long userId){
        return recommendationService.matching(userId);
    }
}
