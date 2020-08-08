package abhishek.foundation.bank.bankcasestudy.dao;

import java.util.List;

import abhishek.foundation.bank.bankcasestudy.entity.Customer;

public interface CustomerDAO {
	
	public Customer getCustomer(String id);
	public List<Customer> getAllCustomers();
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(String id, String firstName, String lastName, String email);
	public Customer deleteCustomer(String id);

}
