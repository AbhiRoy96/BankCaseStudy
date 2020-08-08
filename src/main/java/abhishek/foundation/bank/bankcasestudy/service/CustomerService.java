package abhishek.foundation.bank.bankcasestudy.service;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abhishek.foundation.bank.bankcasestudy.entity.Account;
import abhishek.foundation.bank.bankcasestudy.entity.Customer;
import abhishek.foundation.bank.bankcasestudy.exception.CustomerNotFound;
import abhishek.foundation.bank.bankcasestudy.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AccountService service;
	
	public Customer getCustomer(String id) {
		// TODO Auto-generated method stub
		Customer customer = customerRepo.findOneCustomerById(id);
		if(customer == null) {
			throw new CustomerNotFound("Customer was not found with Customer ID: " + id);
		}
		return customer;
	}
	
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = (List<Customer>) customerRepo.findAll();
		if(customers.size() > 0) {
			return customers;
		}
		return null;
	}
	
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer newRecord = customerRepo.save(customer);
		if(newRecord != null) {
			return newRecord;
		}
		return null;
	}
	
	@Transactional
	public void updateCustomer(String id, String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		customerRepo.updateCustomer(id, firstName, lastName, email);
	}
	
	public String createNewAccount(String id, String type, Double amount) {
		Customer newCustomer = getCustomer(id);
		if(newCustomer == null) {
			throw new CustomerNotFound("Customer was not found with Customer ID: " + id);
		}
		// CreateAccount and update the HashSet
		Account newAccount = service.createAccount(newCustomer, type, amount);
		// update the changes in DB
		return "Account Created successfully! Account number: " + newAccount.getAccountNumber();
	}
	
	public List<Account> getAllCustomerAccounts(String id) {
		// TODO Auto-generated method stub
		Customer customer = customerRepo.findOneCustomerById(id);
		if(customer != null) {
			Iterable<Account> allAccounts = customer.getAccounts();
			List<Account> allCustomerAccounts = new ArrayList<Account>();
			for(Account acc:allAccounts) {
				allCustomerAccounts.add(acc);
			}
			return allCustomerAccounts;
		}
		throw new CustomerNotFound("Customer was not found with Customer ID: " + id);
	}
	
	
	
}
