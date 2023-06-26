package com.odhiambopaul.demo.services;

import com.odhiambopaul.demo.model.Transaction;
import com.odhiambopaul.demo.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactionRepository.findAll().forEach(transactions::add);
        return transactions;
    }

    @Override
    public Transaction getById(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public Transaction insert(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void update(Long id, Transaction transaction) {
        Transaction transactionFromDb = transactionRepository.findById(id).get();
        System.out.println(transactionFromDb.toString());
        transactionFromDb.setStatus(transaction.getStatus());
        transactionRepository.save(transactionFromDb);
    }

    @Override
    public void delete(Long transaction_id) {
        transactionRepository.deleteById(transaction_id);
    }
}
