package com.example.proxibanque_naim_chefirat.service;

import com.example.proxibanque_naim_chefirat.entity.Client;
import com.example.proxibanque_naim_chefirat.repository.ClientRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @PostConstruct
    private void initDB() {
        repository.saveAll(List.of(
                new Client("John", "Doe")
        ));
    }


    @Override
    public List<Client> getClients() {
        return repository.findAll();
    }

    @Override
    public Optional<Client> getClient(long id) {
        return repository.findById(id);
    }

    @Override
    public Client createClient(Client client) {
        return repository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        var maybe = getClient(client.getId());
        if (maybe.isPresent()) {
            var c = maybe.get();
            c.setFirstName(client.getFirstName());
            c.setLastName(client.getLastName());
            c.setCheckingAccount(client.getCheckingAccount());
            c.setSavingAccount(client.getSavingAccount());
            return c;
        }
        return repository.save(client);
    }

    @Override
    public boolean deleteClient(long id) {
        var maybe = getClient(id);
        if (maybe.isPresent()) {
            repository.delete(maybe.get());
            return true;
        }
        return false;
    }
}
