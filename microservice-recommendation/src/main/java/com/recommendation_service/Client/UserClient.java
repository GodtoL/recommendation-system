package com.recommendation_service.Client;

import com.recommendation_service.Dto.PurchaseDTO;
import com.recommendation_service.Dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name= "match-user", url = "http://localhost:8090/api/user")
public interface UserClient {
    @GetMapping("/{id}")
    UserDTO getUserById(@PathVariable Long id);
}
