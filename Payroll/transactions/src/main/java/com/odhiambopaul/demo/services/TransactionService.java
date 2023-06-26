package com.odhiambopaul.demo.services;

import com.odhiambopaul.demo.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactions();

    Transaction getById(Long transaction_id);

    Transaction insert(Transaction transaction);

    void update(Long transaction_id, Transaction transaction);

    void delete(Long transactionId);
}
