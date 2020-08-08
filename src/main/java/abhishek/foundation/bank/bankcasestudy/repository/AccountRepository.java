package abhishek.foundation.bank.bankcasestudy.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import abhishek.foundation.bank.bankcasestudy.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	@Query("from Account where accountNumber =:accountNumber")
	public Account findOneAccountById(@Param("accountNumber") Integer accountNumber);

	@Modifying
	@Query("UPDATE Account SET balance = :balance WHERE accountNumber = :accountNumber")
	public void transfer(@Param("accountNumber") Integer accountNumber, @Param("balance") double balance);


}
