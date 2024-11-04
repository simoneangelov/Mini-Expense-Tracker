package com.example.mini_expense_tracker.repository;

import com.example.mini_expense_tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// This is a repository interface that handles CRUD operations for the Expense entity.
// @Repository indicates that this interface is a Spring Data repository.
// In the context of Spring Data JPA, a repository is an interface that extends JpaRepository, which provides various methods for CRUD operations and querying data from the database.

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Additional query methods can be defined here if needed

    // What do I do in this interface?
}
