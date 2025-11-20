package com.example.proxibanque_naim_chefirat.repository;

import com.example.proxibanque_naim_chefirat.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
