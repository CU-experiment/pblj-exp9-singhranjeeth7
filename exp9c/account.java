package entity;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double balance;

    // Constructors
    public Account() {}
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Getters and setters
    // toString()
}