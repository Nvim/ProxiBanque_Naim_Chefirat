package com.example.proxibanque_naim_chefirat.dto;

// This DTO is used to aggregate an account ID and account type,
// so I know which table to search, since I dindn't use inheritence
// in the persistence layer.
public record AccountPayload(
        Long account_id,
        String account_type // Must be "saving" or "checking"
) { }
