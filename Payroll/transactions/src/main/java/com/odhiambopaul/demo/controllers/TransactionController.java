package com.odhiambopaul.demo.controllers;

import com.odhiambopaul.demo.model.Transaction;
import com.odhiambopaul.demo.services.TransactionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @GetMapping({"/{transactionId}"})
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long transactionId) {
        return new ResponseEntity<>(transactionService.getById(transactionId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction) {
        Transaction transaction1 = transactionService.insert(transaction);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("transaction", "/transaction" + transaction1.getTransaction_id());
        return new ResponseEntity<>(transaction1, httpHeaders, HttpStatus.CREATED);
    }
    @PutMapping({"/{transactionId}"})
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("transactionId") Long transactionId, @RequestBody Transaction transaction) {
        transactionService.update(transactionId, transaction);
        return new ResponseEntity<>(transactionService.getById(transactionId), HttpStatus.OK);
    }
    @DeleteMapping({"/{Transaction}"})
    public ResponseEntity<Transaction> deleteTransaction(@PathVariable("Transaction") Long Transaction) {
        transactionService.delete(Transaction);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
