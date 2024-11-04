package com.example.mini_expense_tracker.controller;

import com.example.mini_expense_tracker.model.Expense;
import com.example.mini_expense_tracker.service.ExpenseService;
import com.example.mini_expense_tracker.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// @RestController is a Spring annotation that marks this class as a REST controller.
// It is used to define RESTful web services.
// It combines @Controller and @ResponseBody, indicating that the methods return data that will be automatically converted to JSON and sent to the client.

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    // Instance of ExpenseService is injected into the controller.
    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

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
