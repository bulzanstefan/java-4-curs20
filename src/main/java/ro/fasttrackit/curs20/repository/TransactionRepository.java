package ro.fasttrackit.curs20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fasttrackit.curs20.entities.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    //    @Query("SELECT t from Transaction t where t.description='benzina'") //Java + SQL = JQL ; JQL>SQL
    @Query(value = "SELECT * from Transaction  where description='benzina'", nativeQuery = true)
    List<Transaction> getMyTransaction();

    @Query("SELECT t from Transaction t where t.description=:descriptionParam")
    Optional<Transaction> getMyTransaction(@Param("descriptionParam") String descriptionParam);

    List<Transaction> findAllByDescription(String description);

    List<Transaction> findAllByDescriptionAndAmountGreaterThan(String description, double minAmount);

    List<Transaction> findAllByDescriptionContaining(String desc);

}
