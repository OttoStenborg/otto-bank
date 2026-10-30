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
        this.name = requireCorrectName(name);
    }

    protected Customer() {
    }

    private String requireCorrectName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '-') {
                throw new IllegalArgumentException("Name can only contain letters, spaces and hyphens");
            }
        }
        return name;
    }


    public String getName() {
        return name;
    }

    public void changeName(String name) {
        this.name = requireCorrectName(name);
    }

    public Long getId() {
        return id;
    }


}
