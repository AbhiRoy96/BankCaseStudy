package abhishek.foundation.bank.bankcasestudy;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import abhishek.foundation.bank.bankcasestudy.entity.Account;
import abhishek.foundation.bank.bankcasestudy.entity.Customer;
import abhishek.foundation.bank.bankcasestudy.repository.AccountRepository;
import abhishek.foundation.bank.bankcasestudy.repository.CustomerRepository;


@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class BankcasestudyApplicationTests {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;

	@Test
	@Order(1)
	public void test_addCustomers() {
		Customer cust1 = new Customer(1, "User1", "Abb1", "user.abb1@wipro.com");
		Customer cust2 = new Customer(2, "User2", "Abb2", "user.abb2@wipro.com");
		Customer cust3 = new Customer(3, "User3", "Abb3", "user.abb3@wipro.com");
		Customer cust4 = new Customer(4, "User4", "Abb4", "user.abb4@wipro.com");
		Customer cust5 = new Customer(5, "User5", "Abb5", "user.abb5@wipro.com");
	
		customerRepository.save(cust1);
		customerRepository.save(cust2);
		customerRepository.save(cust3);
		customerRepository.save(cust4);
		customerRepository.save(cust5);
	
	}
	
	@Test
	@Order(2)
	public void test_addAccounts() {
		Account acc1 = new Account("SAVINGS", 100);
		Account acc2 = new Account("CURRENT", 900);
		Account acc3 = new Account("SAVINGS", 860);
		Account acc4 = new Account("CURRENT", 1000);
		Account acc5 = new Account("SAVINGS", 700);
	
		accountRepository.save(acc1);
		accountRepository.save(acc2);
		accountRepository.save(acc3);
		accountRepository.save(acc4);
		accountRepository.save(acc5);
	}
	
	
	@Test
	@Order(3)
	public void test_getCustomers() {
		Iterable<Customer> customers = customerRepository.findAll();
		for(Customer customer:customers) {
			System.out.println(customer.getCustomerId());
		}
	
	}
	
	
	
	@Test
	@Order(4)
	public void test_getAccounts() {
		Iterable<Account> accounts = accountRepository.findAll();
		for(Account account:accounts) {
			System.out.println(account.getAccountNumber());
		}
	
	}


}
