package com.recommendation_service.Controller;

import com.recommendation_service.Service.RecommendationService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/recommend-product")
public class RecommendController {

    private final Map<Long, String> tokenStorage = new HashMap<>(); // Almacena tokens generados asociados con el userId

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private RabbitTemplate rabbitTemplate; // Para enviar mensajes a RabbitMQ

    // Configuración rápida para el nombre de la cola (puedes cambiarla si lo necesitas)
    private static final String QUEUE_NAME = "recommendationQueue";

    // Endpoint para generar el token dinámico
    @GetMapping("/generate-token/{userId}")
    public ResponseEntity<String> generateToken(@PathVariable Long userId) {
        String dynamicToken = "Bearer " + UUID.randomUUID().toString();
        tokenStorage.put(userId, dynamicToken); // Asociar token con el userId

        // Enviar el token a la cola de RabbitMQ
       rabbitTemplate.convertAndSend(QUEUE_NAME, "Se generò un token para el usuario " + userId + ", token: " + dynamicToken);

        return ResponseEntity.ok("Generated token: " + dynamicToken);
    }

    // Endpoint para hacer la recomendación, verificando el token dinámico
    @GetMapping("/{userId}")
    public ResponseEntity<String> matching(
            @PathVariable Long userId,
            @RequestHeader("Authorization") String token) {

        // Verificar si el token coincide con el almacenado para ese userId
        String storedToken = tokenStorage.get(userId);
        if (storedToken == null || !storedToken.equals(token)) {
            return new ResponseEntity<>("Unauthorized: Invalid token", HttpStatus.FORBIDDEN);
        }

        // Si el token es válido, procede con la lógica del servicio
        String recommendation = recommendationService.matching(userId);

        // Enviar la recomendación a la cola de RabbitMQ
        rabbitTemplate.convertAndSend(QUEUE_NAME, "Recomendaciòn para el usuario " + userId + " es " + recommendation);

        return ResponseEntity.ok(recommendation);
    }
}
