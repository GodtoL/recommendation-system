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

    @GetMapping("/{category}")
    public List<ProductDTO> matching(@PathVariable String category){
        return recommendationService.matching(category);
    }
}
