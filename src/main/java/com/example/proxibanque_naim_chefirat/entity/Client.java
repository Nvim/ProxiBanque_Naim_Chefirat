package com.example.proxibanque_naim_chefirat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    private SavingAccount savingAccount;

    @OneToOne(cascade = CascadeType.ALL)
    private CheckingAccount checkingAccount;

    public Client(String first_name, String last_name) {
        this.firstName = first_name;
        this.lastName = last_name;
    }
}
