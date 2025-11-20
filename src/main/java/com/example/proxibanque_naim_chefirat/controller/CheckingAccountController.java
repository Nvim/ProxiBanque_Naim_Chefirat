package com.example.proxibanque_naim_chefirat.controller;

import com.example.proxibanque_naim_chefirat.entity.CheckingAccount;
import com.example.proxibanque_naim_chefirat.service.CheckingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CheckingAccountController {
    private final CheckingAccountService service;

    @GetMapping("checkingAccounts")
    public List<CheckingAccount> getCheckingAccounts()
    {
        return service.getCheckingAccounts();
    }

    @GetMapping("checkingAccounts/{id}")
    public ResponseEntity<CheckingAccount> getCheckingAccount(@PathVariable Long id)
    {
        return service.getCheckingAccountById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("checkingAccounts/{id}")
    ResponseEntity<CheckingAccount> updateCheckingAccount(@PathVariable Long id, @RequestBody CheckingAccount account) {
        if (service.getCheckingAccountById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.updateCheckingAccount(account));
    }
}
