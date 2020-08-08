package abhishek.foundation.bank.bankcasestudy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abhishek.foundation.bank.bankcasestudy.entity.Transaction;
import abhishek.foundation.bank.bankcasestudy.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepo;
	
	@Autowired
	AccountService service;
	
	@Transactional
	public Transaction newTransaction(Integer fromAccount, Integer toAccount, double amount) {
		Transaction tran = new Transaction("SWIFT Transfer", fromAccount, toAccount, amount);
		
		if(service.tansfer(fromAccount, toAccount, amount).compareTo("success") == 0) {
			tran.setStatus("Successful");
		} else {
			tran.setStatus("Failed");
		}
		transactionRepo.save(tran);
		return tran;
	}
	
	
	
}
