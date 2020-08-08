package abhishek.foundation.bank.bankcasestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import abhishek.foundation.bank.bankcasestudy.entity.Account;
import abhishek.foundation.bank.bankcasestudy.entity.Customer;
import abhishek.foundation.bank.bankcasestudy.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService svc;
	
//	@Value("${message}")
//	public String message;
//	
//	@GetMapping("/")
//	public String indexInfo() {
//		return message;
//	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable String id) {
		return svc.getCustomer(id);
	}
	
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return svc.getAllCustomers();
	}
	
	
	@GetMapping("/customers/accounts")
	public List<Customer> getAllCustomersAccounts(){
		return svc.getAllCustomers();
	}
	
	
	@GetMapping("/customers/{id}/accounts")
	public List<Account> getCustomersAccounts(@PathVariable String id){
		return svc.getAllCustomerAccounts(id);
	}
	
	
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return svc.createCustomer(customer);
	}
	
	@PostMapping("/customers/{id}/account")
	public String createCustomerAccount(@PathVariable String id, @RequestBody Account account) {
		return svc.createNewAccount(id, account.getAccountType(), account.getBalance());
	}
	

	@PutMapping("/customers/{id}")
	public String updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
		svc.updateCustomer(id, customer.getFirstName(), customer.getLastName(), customer.getEmail());
		return "Update Successful";
	}

	
//	DELETE Implemented in DAO
//	@DeleteMapping("/customers/{id}")
//	public Customer deleteCustomer(@PathVariable String id) {
//		return dao.deleteCustomer(id);
//	}
	
}
