package com.matching_system.users.Controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {

    // Método que recibe los mensajes de la cola
    @RabbitListener(queues = "recommendationQueue")  // Escucha la cola recommendationQueue
    public void receiveMessage(String message) {
        // Aquí procesas el mensaje recibido
        System.out.println("Received message: " + message);
    }
}
