package abhishek.foundation.bank.bankcasestudy.dao;

import java.util.List;

import abhishek.foundation.bank.bankcasestudy.entity.Account;

public interface AccountDAO {
	
	public Account getAccount(Integer id);
	public List<Account> GetAllAccounts();
	public Account createAccount(Account account);
	public Account updateAccount(Integer id, String type);
	public boolean credit(Integer id, double amount);
	public boolean debit(Integer id, double amount);
	public double balance(Integer id, double amount);
	public Account deleteAccount(Integer id);
	
}
