package abhishek.foundation.bank.bankcasestudy.repository;

import org.springframework.data.repository.CrudRepository;

import abhishek.foundation.bank.bankcasestudy.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

}
