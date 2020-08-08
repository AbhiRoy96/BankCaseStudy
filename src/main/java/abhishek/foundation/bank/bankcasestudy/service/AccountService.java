package abhishek.foundation.bank.bankcasestudy.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abhishek.foundation.bank.bankcasestudy.entity.Account;
import abhishek.foundation.bank.bankcasestudy.entity.Customer;
import abhishek.foundation.bank.bankcasestudy.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepo;
	
	public List<Account> GetAllAccounts() {
		// TODO Auto-generated method stub
		List<Account> accounts = (List<Account>) accountRepo.findAll();
		if(accounts.size() > 0) {
			return accounts;
		}
		return null;
	}

	public Account getAccount(Integer id) {
		// TODO Auto-generated method stub
		Account account = accountRepo.findOneAccountById(id);
		if(account != null) {
			return account;
		}
		return null;
	}
	
	public Account createAccount(Customer cust, String type, double amt) {
		Account newAccount = new Account(type, amt);
		HashSet<Customer> custList = new HashSet<Customer>();
		custList.add(cust);
		newAccount.setCustomers(custList);
		
		newAccount = accountRepo.save(newAccount);
		return newAccount;
	}
	
	public String tansfer(Integer fromAccount, Integer toAccount, double amount) {
		Account fromAcc = getAccount(fromAccount);
		Account toAcc = getAccount(toAccount);
		
		if(fromAcc == null) {
			return "Account doesnot exist: " + fromAccount.toString();
		}
		else if(toAcc == null) {
			return "Account doesnot exist: " + toAccount.toString();
		} else {
			if(fromAcc.getBalance() >= amount) {
				accountRepo.transfer(fromAccount, fromAcc.debit(amount));
				accountRepo.transfer(toAccount, toAcc.credit(amount));
				return "success";
			}
			else {
				return "Account: " + toAccount.toString() + " doesnot have sufficient funds!";
			}
		}
	}


}
