package com.example.proxibanque_naim_chefirat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CheckingAccount implements BankAccountInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double balance;

    private final static double MAX_DECOUVERT = 1000;
    private final static double REMUNERATION = 0;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getMaxDecouvert() {
        return MAX_DECOUVERT;
    }

    @Override
    public double getRemuneration() {
        return REMUNERATION;
    }
}
