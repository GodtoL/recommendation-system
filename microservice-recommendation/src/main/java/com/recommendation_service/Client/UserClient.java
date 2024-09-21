package com.recommendation_service.Client;

import com.recommendation_service.Dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "match-user", url = "localhost:8090/api/user")
public interface UserClient {
    @GetMapping("/{id}")
    List<UserDTO> getUserById(@PathVariable Long id);
}
