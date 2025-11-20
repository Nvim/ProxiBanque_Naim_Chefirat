package com.example.proxibanque_naim_chefirat;

import com.example.proxibanque_naim_chefirat.entity.Client;
import com.example.proxibanque_naim_chefirat.service.ClientService;
import com.example.proxibanque_naim_chefirat.service.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProxiBanqueNaimChefiratApplicationTests {

    @Test
    void contextLoads() {
        Client client = new Client("first_name", "last_name");
    }

}
