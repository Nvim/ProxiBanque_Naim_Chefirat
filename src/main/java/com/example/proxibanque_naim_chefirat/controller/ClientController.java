package com.example.proxibanque_naim_chefirat.controller;

import com.example.proxibanque_naim_chefirat.entity.Client;
import com.example.proxibanque_naim_chefirat.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping("clients")
    List<Client> getClients() {
       return service.getClients();
    }
}
