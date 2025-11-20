package com.example.proxibanque_naim_chefirat.service;

import com.example.proxibanque_naim_chefirat.entity.CheckingAccount;
import com.example.proxibanque_naim_chefirat.entity.SavingAccount;

import java.util.List;
import java.util.Optional;

public interface SavingAccountService {
    List<SavingAccount> getSavingAccounts();
    Optional<SavingAccount> getSavingAccountById(long id);
    SavingAccount updateSavingAccount(SavingAccount checkingAccount);
}
