package com.recommendation_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private LocalDateTime registrationDate;
    private int age;
    private String address;
    private String phoneNumber;
}
