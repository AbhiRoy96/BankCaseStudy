package abhishek.foundation.bank.bankcasestudy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import abhishek.foundation.bank.bankcasestudy.entity.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO{
	
	private static List<Customer> customerList = new ArrayList<Customer>();
	
	static {
		customerList.add(new Customer(1, "User1", "Abb1", "user.abb1@wipro.com"));
		customerList.add(new Customer(2, "User2", "Abb2", "user.abb2@wipro.com"));
		customerList.add(new Customer(3, "User3", "Abb3", "user.abb3@wipro.com"));
		customerList.add(new Customer(4, "User4", "Abb4", "user.abb4@wipro.com"));
		customerList.add(new Customer(5, "User5", "Abb5", "user.abb5@wipro.com"));
		
	}

	@Override
	public Customer getCustomer(String id) {
		// TODO Auto-generated method stub
		for(Customer customer:customerList) {
			if(id.compareTo(customer.returncustomerId()) == 0 ) {
				return customer;
			}
		}
		
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		if(customerList.size() > 0)
			return customerList;
		return null;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		if(customer != null) {
			customerList.add(customer);
			return customer;
		}
		
		return null;
	}

	@Override
	public Customer updateCustomer(String id, String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		for(Customer customer:customerList) {
			if(id.compareTo(customer.returncustomerId()) == 0 ) {
				customer.updateFirstName(firstName);
				customer.updateLastName(lastName);
				customer.updateEmail(email);
				return customer;
			}
		}
		
		return null;
	}

	@Override
	public Customer deleteCustomer(String id) {
		// TODO Auto-generated method stub
		int index = 0;
		for(Customer cust:customerList) {
			if(cust.returncustomerId().compareTo(id) == 0 ) {
				customerList.remove(index);
				return cust;
			}
			index++;
		}
		
		return null;
	}

}
