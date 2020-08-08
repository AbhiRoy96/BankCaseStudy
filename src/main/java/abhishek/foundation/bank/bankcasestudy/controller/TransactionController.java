package abhishek.foundation.bank.bankcasestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import abhishek.foundation.bank.bankcasestudy.entity.Transaction;
import abhishek.foundation.bank.bankcasestudy.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService tService;
	
	@PutMapping("/accounts/transferFund")
	public Transaction updateAccount(@RequestBody Transaction transaction) {
		return tService.newTransaction(transaction.getFromAccount(), transaction.getToAccount(), transaction.getAmount());
	}
	
	
}
