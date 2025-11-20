package com.example.proxibanque_naim_chefirat.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

// This interface is used purely for application-level logic.
// As clients only have a single account of each kind, I choose
// not to model the inheritance relationship in the persistence layer.
public interface BankAccountInterface {
    double getBalance();
    double getMaxDecouvert();
    double getRemuneration();
    void setBalance(double amount);

    default boolean sendMoneyTo(BankAccountInterface dst, double amount) {
        if (amount <= 0) {
            return false;
        }
        var srcBalance = getBalance();
        var diff = srcBalance - amount;

        if (Math.abs(diff) > getMaxDecouvert()) {
            return false;
        }

        dst.setBalance(dst.getBalance() + amount);
        return true;
    }

    long getId();
}
