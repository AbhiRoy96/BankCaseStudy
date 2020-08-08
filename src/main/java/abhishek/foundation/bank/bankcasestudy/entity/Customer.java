package abhishek.foundation.bank.bankcasestudy.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Customer {
	@Id
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="customers")
	private Set<Account> accounts;
	

	public Customer() {

	}
	
	public Customer(int id, String fname, String lname, String email) {
		this.customerId = generateCustomerId(id);
		this.firstName = fname;
		this.lastName = lname;
		this.email = email;
		this.accounts = new HashSet<Account>();
	}
	
	
	
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	private String generateCustomerId(int id) {
		int count = 1000;
		count = count + id;
		return "CX" + count;
	}
	
	public String returncustomerId() {
		return this.customerId;
	}
	
	public String returnFirstName() {
		return this.firstName;
	}
	
	public String returnLastName() {
		return this.lastName;
	}
	
	public String returnEmail() {
		return this.email;
	}
	
	public void updateFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void updateLastName(String lastname) {
		this.lastName = lastname;
	}
	
	public void updateEmail(String email) {
		this.email = email;
	}
	
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
}
