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
public class SavingAccount implements BankAccountInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final double MAX_DECOUVERT = 0;
    private final double REMUNERATION = 3;

    private double balance;

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getMaxDecouvert() {
        return 0;
    }

    @Override
    public double getRemuneration() {
        return 0;
    }
}
