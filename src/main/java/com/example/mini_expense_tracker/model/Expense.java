package com.example.mini_expense_tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

// This is the Expense class that represents an expense record in the database.

/**
 * '@Entity tells JPA (like Hibernate) that this class represents a database table.
 * In this case, the Expense class corresponds to an "expense" table in the database,
 * and each instance of Expense represents a row in that table.
 */
@Entity
public class Expense {

    /**
     * 'Id' tells JPA that this field (id) is the primary key of the table.
     * 'GeneratedValue(strategy = GenerationType.IDENTITY)' tells JPA that the database should automatically generate the value for the id field.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The id field is the primary key, and the other fields below are the data for each expense record.
    @Column(name = "desrc")
    private String desrc;
    
    @Column(name = "amount")
    private BigDecimal amount;
    
    // Use @Column to specify the column name if it differs or to handle reserved keywords
    @Column(name = "date_added") // Updated column name to avoid reserved keyword
    private LocalDate dateAdded;

    // Default constructor
    public Expense() {}

    // Constructor with parameters
    public Expense(String desrc, BigDecimal amount, LocalDate dateAdded) {
        this.desrc = desrc;
        this.amount = amount;
        this.dateAdded = dateAdded;
    }

    // Getters and Setters -----------------------------------------------------

    public Long getId() {
        return id;
    }

    // No setter for ID because it's auto-generated

    public String getDesrc() {
        return desrc;
    }

    public void setDesrc(String desrc) {
        this.desrc = desrc;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
