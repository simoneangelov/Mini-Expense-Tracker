package com.example.mini_expense_tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.math.BigDecimal;
import java.time.LocalDate;

// This is the Expense class that represents an expense record in the database.

// @Entity tells JPA (like Hibernate) that this class represents a database table.
// In this case, the Expense class corresponds to an "expenses" table in the database,
// and each instance of Expense represents a row in that table.
@Entity
public class Expense {

    // @Id tells JPA that this field (id) is the primary key of the table.
    // @GeneratedValue(strategy = GenerationType.IDENTITY) tells JPA that the database should automatically generate (!!) the value for the id field.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The id field is the primary key, and the other fields below are the data for each expense record.
    private String description;
    private BigDecimal amount;
    private LocalDate date;

    // Default constructor
    public Expense() {}

    // Constructor with parameters
    public Expense(String description, BigDecimal amount, LocalDate date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters -----------------------------------------------------

    public Long getId() {
        return id;
    }

    // No setter for ID because it's auto-generated

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
