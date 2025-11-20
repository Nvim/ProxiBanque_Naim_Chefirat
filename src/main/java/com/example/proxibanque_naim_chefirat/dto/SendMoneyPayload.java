package com.example.proxibanque_naim_chefirat.dto;

public record SendMoneyPayload(
        double amount,
        AccountPayload src,
        AccountPayload dst
) { }
