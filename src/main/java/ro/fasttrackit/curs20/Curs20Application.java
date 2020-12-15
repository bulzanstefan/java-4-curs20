package ro.fasttrackit.curs20;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs20.entities.Transaction;
import ro.fasttrackit.curs20.repository.TransactionRepository;

@SpringBootApplication
public class Curs20Application {

    public static void main(String[] args) {
        SpringApplication.run(Curs20Application.class, args);
    }

    @Bean
    CommandLineRunner atStartup(TransactionRepository transactionRepository) {
        return args -> {
            Transaction paine = transactionRepository.save(new Transaction("paine", 3));
            transactionRepository.save(new Transaction("benzina", 50));
            transactionRepository.save(new Transaction("benzina", 150));
            transactionRepository.save(new Transaction("benzina", 250));
            transactionRepository.save(new Transaction("benzina", 350));

            Transaction paineFromDb = transactionRepository.findById(paine.getId())
                    .orElseThrow();

            paineFromDb.setDescription("new paine");
            transactionRepository.save(paineFromDb);

            transactionRepository.delete(paineFromDb);

            System.out.println(transactionRepository.getMyTransaction());
            System.out.println(transactionRepository.getMyTransaction("paine"));
            System.out.println(transactionRepository.getMyTransaction("altceva"));

            System.out.println(transactionRepository.findAllByDescription("paine"));

            System.out.println("find by description and amount min");
            System.out.println(transactionRepository.findAllByDescriptionAndAmountGreaterThan("benzina", 100));
        };
    }
}
