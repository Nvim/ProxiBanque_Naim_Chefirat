package com.example.proxibanque_naim_chefirat.service;

import com.example.proxibanque_naim_chefirat.entity.BankAccountInterface;
import com.example.proxibanque_naim_chefirat.entity.CheckingAccount;
import com.example.proxibanque_naim_chefirat.repository.CheckingAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckingAccountServiceImpl implements CheckingAccountService {
    private final CheckingAccountRepository checkingAccountRepository;
    @Override
    public List<CheckingAccount> getCheckingAccounts() {
        return checkingAccountRepository.findAll();
    }

    @Override
    public Optional<CheckingAccount> getCheckingAccountById(long id) {
        return checkingAccountRepository.findById(id);
    }

    @Override
    public CheckingAccount updateCheckingAccount(CheckingAccount account) {
        var maybe = checkingAccountRepository.findById(account.getId());
        if (maybe.isPresent()) {
            var ret = maybe.get();
            ret.setBalance(account.getBalance());
            return ret;
        }
        return  checkingAccountRepository.save(account);
    }

    @Override
    public boolean sendMoneyTo(BankAccountInterface dst, double amount) {
        var maybe = checkingAccountRepository.findById(dst.getId());
        if (maybe.isPresent()) {
            var ret = maybe.get();
            return ret.sendMoneyTo(dst, amount);
        }
        return false;
    }
}
