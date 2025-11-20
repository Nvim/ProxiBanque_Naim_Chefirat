package com.example.proxibanque_naim_chefirat.controller;

import com.example.proxibanque_naim_chefirat.entity.Client;
import com.example.proxibanque_naim_chefirat.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService service;

    @GetMapping("clients")
    List<Client> getClients() {
       return service.getClients();
    }

    @GetMapping("clients/{id}")
    ResponseEntity<Client> getClient(@PathVariable Long id) {
        return service.getClient(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("clients")
    Client createClient(@RequestBody Client client) {
        return service.createClient(client);
    }

    @PutMapping("clients/{id}")
    ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        if (service.getClient(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.updateClient(client));
    }

    @DeleteMapping("clients/{id}")
    ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        var ret = service.deleteClient(id);
        if (ret) {
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }
}
