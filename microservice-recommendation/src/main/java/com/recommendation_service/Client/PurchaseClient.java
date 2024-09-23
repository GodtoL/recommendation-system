package com.recommendation_service.Client;

import com.recommendation_service.Dto.PurchaseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "match-user-purchase", url = "localhost:8080/api/purchase")
public interface PurchaseClient {
    @GetMapping("/{id}")
    List<PurchaseDTO> getPurchasesById(@PathVariable Long id);
}
