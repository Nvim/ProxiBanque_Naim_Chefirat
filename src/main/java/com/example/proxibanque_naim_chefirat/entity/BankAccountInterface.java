package com.example.proxibanque_naim_chefirat.entity;

// This interface is used purely for application-level logic.
// As clients only have a single account of each kind, I choose
// not to model the inheritance relationship in the persistence layer.
public interface BankAccountInterface {
    double getBalance();
    double getMaxDecouvert();
    double getRemuneration();
}
