package com.matching_system.users.Controllers;

import com.matching_system.users.Models.PurchaseHistory;
import com.matching_system.users.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
    public ResponseEntity<?> getPurchasesByUserId(@PathVariable Long id) {
        try {
            List<PurchaseHistory> purchases = purchaseService.getPurchaseById(id);
            return ResponseEntity.ok(purchases);
        } catch (NoSuchElementException e) {
            // Devuelve un 404 si no se encuentran compras
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron compras para el usuario con id " + id);
        }
    }

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody PurchaseHistory purchaseHistory){
        return ResponseEntity.ok(purchaseService.savePurchase(purchaseHistory));
    }
}
