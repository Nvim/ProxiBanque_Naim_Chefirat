package com.example.proxibanque_naim_chefirat.service;

import com.example.proxibanque_naim_chefirat.entity.Client;

import java.util.Optional;
import java.util.List;

public interface ClientService {
    List<Client> getClients();

    Optional<Client> getClient(long id);
    Client createClient(Client client);
    Client updateClient(Client client);
}
