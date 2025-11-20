package com.example.proxibanque_naim_chefirat.service;

import com.example.proxibanque_naim_chefirat.entity.BankAccountInterface;
import com.example.proxibanque_naim_chefirat.entity.CheckingAccount;

import java.util.List;
import java.util.Optional;

public interface CheckingAccountService {
    List<CheckingAccount> getCheckingAccounts();
    Optional<CheckingAccount> getCheckingAccountById(long id);
    CheckingAccount updateCheckingAccount(CheckingAccount checkingAccount);
    boolean sendMoneyTo(BankAccountInterface dst, double amount);
}
