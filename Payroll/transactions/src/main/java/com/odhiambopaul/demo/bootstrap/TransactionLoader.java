package com.odhiambopaul.demo.bootstrap;

import com.odhiambopaul.demo.model.Transaction;
import com.odhiambopaul.demo.model.TransactionStatus;
import com.odhiambopaul.demo.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TransactionLoader implements CommandLineRunner {
    public final TransactionRepository transactionRepository;

    public TransactionLoader(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadTransactions();
    }

    private void loadTransactions() {
        if (transactionRepository.count() == 0) {
            transactionRepository.save(
                    Transaction.builder()
                            .employee_id(33)
                            .month("2022/4")
                            .status(TransactionStatus.NOT_ACCEPTED)
                            .build()
            );
            transactionRepository.save(
                    Transaction.builder()
                            .employee_id(33)
                            .month("2022/4")
                            .status(TransactionStatus.NOT_ACCEPTED)
                            .build()
            );
            System.out.println("Sample Transactions Loaded");
        }
    }
}
