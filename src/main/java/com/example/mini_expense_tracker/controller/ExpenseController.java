package com.example.mini_expense_tracker.controller;

import com.example.mini_expense_tracker.model.Expense;
import com.example.mini_expense_tracker.service.ExpenseService;
import com.example.mini_expense_tracker.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This handles HTTP requests related to expenses. It defines endpoints for creating, retreiving, updating, and deleting expenses.
// @RestController means that the methods in this class return data directly as HTTP responses, typically in a JSON format.
// @RequestMapping("/api/expenses") annotation specifies that all the endpoints in this controller will be prefixed with "/api/expenses".

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    // Declares expenseService as a field (!!) in the ExpenseController class.
    private final ExpenseService expenseService;

    // Instance of ExpenseService is injected into the controller.
    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // --------------------------------------Defining endpoints----------------------------------------------------------

    // Add a new expense
    // ExpenseController receives a POST request to add a new expense, validates the data, and passes it to ExpenseService for processing.
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // Get all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // Get expense by ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable(value = "id") Long expenseId)
            throws ResourceNotFoundException {
        Expense expense = expenseService.getExpenseById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found for this id :: " + expenseId));
        return ResponseEntity.ok().body(expense);
    }

    // Update an existing expense
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable(value = "id") Long expenseId,
                                                 @RequestBody Expense expenseDetails) throws ResourceNotFoundException {
        Expense updatedExpense = expenseService.updateExpense(expenseId, expenseDetails);
        return ResponseEntity.ok(updatedExpense);
    }

    // Delete an expense
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable(value = "id") Long expenseId) throws ResourceNotFoundException {
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.noContent().build();
    }
}
