package ro.fasttrackit.curs20.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs20.entities.Transaction;
import ro.fasttrackit.curs20.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public List<Transaction> getAll() {
        return repo.findAll();
    }
}
