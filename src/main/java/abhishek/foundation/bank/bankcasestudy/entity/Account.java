package abhishek.foundation.bank.bankcasestudy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountNumber;
	private String accountType;
	private double balance;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "customer_accounts", 
			joinColumns = @JoinColumn(name = "account_id"), 
			inverseJoinColumns = @JoinColumn(name = "customer_id")
			)
	@JsonIgnore
	private Set<Customer> customers;
	
	

	public Account() {
		
	}
	
	public Account (String type, double balance) {
		this.accountType = type;
		this.balance = balance;
		this.customers = new HashSet<Customer>();
	}
	
	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Integer returnAccountNumber() {
		return this.accountNumber;
	}
	
	public String returnAccountType() {
		return this.accountType;
	}
	
	public void updateAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public double returnBalance() {
		return this.balance;
	}
	
	public double credit(double amount) {
			this.balance = this.balance + amount;
			return this.balance;
	}
	
	public double debit(double amount) {
			this.balance = this.balance - amount;
			return this.balance;
	}
	
	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
	
	
}
