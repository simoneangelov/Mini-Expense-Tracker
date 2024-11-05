package com.example.mini_expense_tracker.repository;

import com.example.mini_expense_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This is a repository interface that handles CRUD operations for the Expense entity.
// @Repository indicates that this interface is a Spring Data repository.
// In the context of Spring Data JPA, a repository is an interface that extends JpaRepository, which provides various methods for CRUD operations and querying data from the database.
// ExpenseRepository provides an interface for saving and retrieving expenses from the database. This layer doesn’t contain any business logic, only data access

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Additional query methods can be defined here if needed

    // The ExpenseRepository interface extends JpaRepository, which is a part of Spring Data JPA.
    // By extending JpaRepository, you automatically inherit a set of CRUD operations for the Expense entity WITHOUT
    // needing to explicitly define them in the interface. This is why the ExpenseRepository interface appears empty.
    // For context, JpaRepository is a Spring Data interface that provides a set of standard CRUD operations for entities.
    // ^^ By extending JpaRepository, my repository interface inherits these methods, allowing me to perform database operations without having to write boilerplate code.
}
