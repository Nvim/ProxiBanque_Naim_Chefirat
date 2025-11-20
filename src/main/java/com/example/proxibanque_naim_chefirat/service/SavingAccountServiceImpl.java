package com.example.proxibanque_naim_chefirat.service;

import com.example.proxibanque_naim_chefirat.entity.BankAccountInterface;
import com.example.proxibanque_naim_chefirat.entity.SavingAccount;
import com.example.proxibanque_naim_chefirat.repository.CheckingAccountRepository;
import com.example.proxibanque_naim_chefirat.repository.SavingAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SavingAccountServiceImpl implements SavingAccountService {
    private final SavingAccountRepository savingAccountRepository;
    @Override
    public List<SavingAccount> getSavingAccounts() {
        return savingAccountRepository.findAll();
    }

    @Override
    public Optional<SavingAccount> getSavingAccountById(long id) {
        return savingAccountRepository.findById(id);
    }

    @Override
    public SavingAccount updateSavingAccount(SavingAccount account) {
        var maybe = savingAccountRepository.findById(account.getId());
        if (maybe.isPresent()) {
            var ret = maybe.get();
            ret.setBalance(account.getBalance());
            return ret;
        }
        return  savingAccountRepository.save(account);
    }

    @Override
    public boolean sendMoneyTo(BankAccountInterface dst, double amount) {
        var maybe = savingAccountRepository.findById(dst.getId());
        if (maybe.isPresent()) {
            var ret = maybe.get();
            return ret.sendMoneyTo(dst, amount);
        }
        return false;
    }
}
