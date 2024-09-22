package com.matching_system.users.Controllers;

import com.matching_system.users.Models.PurchaseHistory;
import com.matching_system.users.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseHistoryController {
    @Autowired
    PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPurchases(){
        return ResponseEntity.ok(purchaseService.getPurchases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchasesByUserId(@PathVariable Long id){
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody PurchaseHistory purchaseHistory){
        return ResponseEntity.ok(purchaseService.savePurchase(purchaseHistory));
    }
}
