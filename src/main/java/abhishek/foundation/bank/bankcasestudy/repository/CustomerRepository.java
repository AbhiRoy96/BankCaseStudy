package abhishek.foundation.bank.bankcasestudy.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import abhishek.foundation.bank.bankcasestudy.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

	@Query("from Customer where customerId =:customerId")
	public Customer findOneCustomerById(@Param("customerId") String customerId);
	
//	@Query("select emp.firstName,emp.lastName from Employee emp")
//	public List<Object[]> getEmployees();
	
	@Modifying
	@Query("UPDATE Customer SET firstName = :firstName, lastName = :lastName, email = :email  WHERE customerId = :customerId")
	public void updateCustomer(@Param("customerId") String customerId, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email);
}
