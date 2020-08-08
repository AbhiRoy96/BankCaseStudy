package abhishek.foundation.bank.bankcasestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import abhishek.foundation.bank.bankcasestudy.entity.Account;
import abhishek.foundation.bank.bankcasestudy.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService svc;
	
	@GetMapping("/accounts")
	public List<Account> getAccount(){
		return svc.GetAllAccounts();
	}
	
	
	@GetMapping("/accounts/{id}")
	public Account getAccount(@PathVariable Integer id) {
		return svc.getAccount(id);
	}
	
	
//	@PostMapping("/accounts")
//	public Account createAccount(@RequestBody Account account) {
//		return accDao.createAccount(account);
//	}
	
	
//	@PutMapping("/accounts/{id}")
//	public Account updateAccount(@PathVariable String id, @RequestBody Account account) {
//		return accDao.updateAccount(id, account.getAccountType());
//	}
	
	
//	@DeleteMapping("/accounts/{id}")
//	public Account deleteAccount(@PathVariable String id) {
//		return accDao.deleteAccount(id);
//	}
	
	
}
