package com.example.proxibanque_naim_chefirat.controller;

import com.example.proxibanque_naim_chefirat.dto.SendMoneyPayload;
import com.example.proxibanque_naim_chefirat.entity.BankAccountInterface;
import com.example.proxibanque_naim_chefirat.service.CheckingAccountService;
import com.example.proxibanque_naim_chefirat.service.SavingAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {
    private final CheckingAccountService checkingSrv;
    private final SavingAccountService savingSrv;

    @PostMapping("/send")
    public void send(SendMoneyPayload payload) {
        var amount = payload.amount();
        BankAccountInterface src = null;
        BankAccountInterface dst = null;
        if (payload.src().account_type() == "saving") {
            var maybe = savingSrv.getSavingAccountById(payload.src().account_id());
            if (!maybe.isPresent()) {
//                 return new ResponseEntity();
                return;
            }
            src = maybe.get();
        } else if (payload.src().account_type() == "checking") {
            // same with checking service
        }
        // do the same for dst as well

        // delegate
        if (src != null && dst != null) {
            src.sendMoneyTo(dst, amount);
        }
    }
}
