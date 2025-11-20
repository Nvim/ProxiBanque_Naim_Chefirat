package com.example.proxibanque_naim_chefirat.repository;

import com.example.proxibanque_naim_chefirat.entity.CheckingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long> {
}
