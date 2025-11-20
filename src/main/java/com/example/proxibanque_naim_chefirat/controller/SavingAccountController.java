package com.example.proxibanque_naim_chefirat.controller;

import com.example.proxibanque_naim_chefirat.entity.SavingAccount;
import com.example.proxibanque_naim_chefirat.service.SavingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SavingAccountController {
    private final SavingAccountService service;

    @GetMapping("savingAccounts")
    public List<SavingAccount> getCheckingAccounts()
    {
        return service.getSavingAccounts();
    }

    @GetMapping("savingAccounts/{id}")
    public ResponseEntity<SavingAccount> getSavingAccount(@PathVariable Long id)
    {
        return service.getSavingAccountById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("savingAccounts/{id}")
    ResponseEntity<SavingAccount> updateSavingAccount(@PathVariable Long id, @RequestBody SavingAccount account) {
        if (service.getSavingAccountById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.updateSavingAccount(account));
    }
}
