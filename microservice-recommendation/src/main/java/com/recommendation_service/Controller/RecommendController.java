package com.recommendation_service.Controller;

import com.recommendation_service.Dto.ProductDTO;
import com.recommendation_service.Dto.PurchaseDTO;
import com.recommendation_service.Dto.UserDTO;
import com.recommendation_service.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommend-product")
public class RecommendController {

    private static final String STATIC_TOKEN = "Bearer 12345";

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public ResponseEntity<String> matching(
            @PathVariable Long userId,
            @RequestHeader("Authorization") String token) {
        System.out.println(token);

        // Verificar si el token coincide con el token estático
        if (!STATIC_TOKEN.equals(token)) {
            return new ResponseEntity<>("Unauthorized: Invalid token " + token, HttpStatus.FORBIDDEN);
        }

        // Si el token es válido, procede con la lógica del servicio
        String recommendation = recommendationService.matching(userId);
        return ResponseEntity.ok(recommendation);
    }
}
