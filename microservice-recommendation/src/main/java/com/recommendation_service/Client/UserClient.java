package com.recommendation_service.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserClient {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime registrationDate;
    private int age;
    private String address;
    private String phoneNumber;

}
