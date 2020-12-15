package ro.fasttrackit.curs20.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.curs20.entities.Transaction;
import ro.fasttrackit.curs20.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    List<Transaction> getAll() {
        return service.getAll();
    }
}
