package se.ottobank.otto.bank.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "customers")
public class Customer {
    @Column(nullable = false)
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Customer(String name) {
        this.name = name;
    }
    protected Customer(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


}
