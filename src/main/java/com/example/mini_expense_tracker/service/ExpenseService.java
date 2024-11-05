package com.example.mini_expense_tracker.service;

import com.example.mini_expense_tracker.model.Expense;
import com.example.mini_expense_tracker.repository.ExpenseRepository;
import com.example.mini_expense_tracker.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service indicates that this class is a Spring service component.
// A service component is a class that contains the core business logic of the application.
// Specifically, it processes data, enforces rules, and interacts with the data layer (repository) to perform operations on the data.
// Methods like addExpense, getAllExpenses, getExpenseById, updateExpense, and deleteExpense handle the respective CRUD operations.
// ExpenseService contains methods for creating, retrieving, updating, and deleting expenses. It may also handle exceptions or enforce validation rules before passing data to the repository.

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Create a new expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Retrieve all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Retrieve expense by ID
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    // Update an existing expense
    public Expense updateExpense(Long id, Expense expenseDetails) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found for this id :: " + id));

        expense.setDesrc(expenseDetails.getDesrc());
        expense.setAmount(expenseDetails.getAmount());
        expense.setDateAdded(expenseDetails.getDateAdded());

        return expenseRepository.save(expense);
    }

    // Delete an expense
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found for this id :: " + id));
        expenseRepository.delete(expense);
    }
}
