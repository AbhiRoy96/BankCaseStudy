package abhishek.foundation.bank.bankcasestudy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import abhishek.foundation.bank.bankcasestudy.entity.Account;

@Component
public class AccountDAOImpl implements AccountDAO {
	private static List<Account> accountList = new ArrayList<Account>();
	
	static {
		accountList.add(new Account("SAVINGS", 100));
		accountList.add(new Account("CURRENT", 900));
		accountList.add(new Account("SAVINGS", 860));
		accountList.add(new Account("CURRENT", 1000));
		accountList.add(new Account("SAVINGS", 700));
		accountList.add(new Account("CURRENT", 500));
	}
	
	

	@Override
	public Account getAccount(Integer id) {
		// TODO Auto-generated method stub
		for(Account account:accountList) {
			if(id.compareTo(account.returnAccountNumber()) == 0 ) {
				return account;
			}
		}
		
		return null;
	}

	@Override
	public List<Account> GetAllAccounts() {
		// TODO Auto-generated method stub
		if(accountList.size() > 0)
			return accountList;
		return null;
	}

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		if(account != null) {
			accountList.add(account);
			return account;
		}
		
		return null;
	}

	@Override
	public Account updateAccount(Integer id, String type) {
		// TODO Auto-generated method stub
		for(Account account:accountList) {
			if(id.compareTo(account.returnAccountNumber()) == 0 ) {
				account.updateAccountType(type);
				return account;
			}
		}
		
		return null;
	}

	@Override
	public boolean credit(Integer id, double amount) {
		// TODO Auto-generated method stub
		for(Account account:accountList) {
			if(id.compareTo(account.returnAccountNumber()) == 0 ) {
				account.credit(amount);;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean debit(Integer id, double amount) {
		// TODO Auto-generated method stub
		for(Account account:accountList) {
			if(id.compareTo(account.returnAccountNumber()) == 0 ) {
				account.debit(amount);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public double balance(Integer id, double amount) {
		for(Account account:accountList) {
			if(id.compareTo(account.returnAccountNumber()) == 0 ) {
				double balance = account.returnBalance();
				return balance;
			}
		}
		return -900;
	}

	@Override
	public Account deleteAccount(Integer id) {
		// TODO Auto-generated method stub
		int index = 0;
		for(Account acc:accountList) {
			if(acc.returnAccountNumber().compareTo(id) == 0 ) {
				accountList.remove(index);
				return acc;
			}
			index++;
		}
		
		return null;
	}

	

}
