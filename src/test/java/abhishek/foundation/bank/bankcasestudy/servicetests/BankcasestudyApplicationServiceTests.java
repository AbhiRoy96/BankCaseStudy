package abhishek.foundation.bank.bankcasestudy.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import abhishek.foundation.bank.bankcasestudy.entity.Account;
import abhishek.foundation.bank.bankcasestudy.entity.Customer;
import abhishek.foundation.bank.bankcasestudy.repository.AccountRepository;
import abhishek.foundation.bank.bankcasestudy.repository.CustomerRepository;
import abhishek.foundation.bank.bankcasestudy.service.AccountService;
import abhishek.foundation.bank.bankcasestudy.service.CustomerService;


@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BankcasestudyApplicationServiceTests {

	@InjectMocks
	CustomerService service1;
	
	@InjectMocks
	AccountService service2;
	
	@Mock
	private CustomerRepository customerRepo;
	@Mock
	private AccountRepository accountRepo;
	@Mock
	private AccountService accSvc;
	

	@Test
	@Order(1)
	public void test_getCustomer() {
		Customer customer = new Customer(1, "First", "Last", "abc@WIPRO.COM");
		when(customerRepo.findOneCustomerById("CX1001")).thenReturn(customer);
		
		Customer testCustomer = service1.getCustomer("CX1001");
		System.out.println(testCustomer.getCustomerId());
		assertEquals("CX1001", testCustomer.getCustomerId());
	}
	
	@Test
	@Order(2)
	public void test_getAllCustomers() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Customer customer1 = new Customer(1, "First", "Last", "abc@WIPRO.COM");
		Customer customer2 = new Customer(2, "Second", "Last", "abc2@WIPRO.COM");
		customerList.add(customer1);
		customerList.add(customer2);
		when(customerRepo.findAll()).thenReturn(customerList);
		
		List<Customer> customers = service1.getAllCustomers();
		System.out.println(customers.get(0).getCustomerId());
		assertEquals("CX1001", customers.get(0).getCustomerId());
	}
	
	
//	public Customer createCustomer(Customer customer)
	@Test
	@Order(3)
	public void test_createCustomer() {
		Customer customer = new Customer(1, "First", "Last", "abc@WIPRO.COM");
		when(customerRepo.save(customer)).thenReturn(customer);
		
		Customer testCustomer = service1.createCustomer(customer);
		System.out.println(testCustomer.getCustomerId());
		assertEquals("CX1001", testCustomer.getCustomerId());
	}
	
	
//	public void updateCustomer(String id, String firstName, String lastName, String email)
	@Test
	@Order(4)
	public void test_updateCustomer() {
		Customer customer_updated = new Customer(1, "First_changed", "Last", "abc@WIPRO.COM");
		when(customerRepo.findOneCustomerById("CX1001")).thenReturn(customer_updated);
		
		service1.updateCustomer("CX1001", "First_changed", "Last", "abc@WIPRO.COM");
		// verifing
		Customer testCustomer = service1.getCustomer("CX1001");
		System.out.println(testCustomer.getCustomerId());
		assertEquals("First_changed", testCustomer.getFirstName());
	}
	
	
	
//	public String createNewAccount(String id, String type, Double amount)
	@Test
	@Order(5)
	public void test_createNewAccount() {
		Customer customer_test = new Customer(1, "First", "Last", "abc@WIPRO.COM");
		Account account_test = new Account("SAVINGS", 200);
		HashSet<Account> account_set = new HashSet<Account>();
		account_set.add(account_test);
		customer_test.setAccounts(account_set);
		
		try {
			when(customerRepo.findOneCustomerById("CX1001")).thenReturn(customer_test);
			when(service1.createNewAccount("CX1001", "SAVINGS", 200.00)).thenReturn("Account Created successfully! Account number: 1");
			
			String outpuText = service1.createNewAccount("CX1001", "SAVINGS", 200.00);
			verify(service1, atLeastOnce()).createNewAccount("CX1001", "SAVINGS", 200.00);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case cannot create a new Account!");
		}
	}

//	public List<Account> GetAllAccounts()
	@Test
	@Order(6)
	public void test_GetAllAccounts() {
		ArrayList<Account> accountList = new ArrayList<Account>();
		Account account1 = new Account("Savings", 200.0);
		account1.setAccountNumber(1);
		Account account2 = new Account("Savings", 400.0);
		account2.setAccountNumber(1);
		accountList.add(account1);
		accountList.add(account2);
		
		when(accountRepo.findAll()).thenReturn(accountList);
		
		List<Account> accounts = service2.GetAllAccounts();
		System.out.println(accounts.get(0).getAccountNumber());
		assertEquals(1, accounts.get(0).getAccountNumber());
	}
	
//	public Account getAccount(Integer id)
	@Test
	@Order(7)
	public void test_getAccount() {
		Account account = new Account("Savings", 200.0);
		account.setAccountNumber(1);
		when(accountRepo.findOneAccountById(1)).thenReturn(account);
		
		Account testAccount = service2.getAccount(1);
		System.out.println(testAccount.getAccountNumber());
		assertEquals(1, testAccount.getAccountNumber());
	}
	
//	public Account createAccount(Customer cust, String type, double amt)
	@Test
	@Order(8)
	public void test_createAccount() {
		
		Customer customer = new Customer(1, "First", "Last", "abc@WIPRO.COM");
		Account account = new Account("Savings", 200.0);
		account.setAccountNumber(1);
	
		try {
			when(accountRepo.save(account)).thenAnswer(invocation -> {
			    Object arg = invocation.getArgument(0);
			    if (account != null) return account;
			    return null;
			});
			
			Account newAccountCreated = service2.createAccount(customer, "SAVINGS", 200);
			verify(accountRepo, atLeastOnce()).save(account);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test case cannot create a new Account!");
		}
	}
		
	
}
