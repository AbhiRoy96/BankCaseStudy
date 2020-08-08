package abhishek.foundation.bank.bankcasestudy.servicetests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import abhishek.foundation.bank.bankcasestudy.controller.CustomerController;
import abhishek.foundation.bank.bankcasestudy.entity.Customer;
import abhishek.foundation.bank.bankcasestudy.service.CustomerService;



@ExtendWith(SpringExtension.class)   
@WebMvcTest(CustomerController.class)
@TestMethodOrder(OrderAnnotation.class)
class BankcasestudyApplicationContollerTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CustomerService service;

	
	
//	@GetMapping("/customers/{id}")
//	public Customer getCustomer(@PathVariable String id)
	@Test
	@Order(1)
	void getCustomer() throws Exception {
		
		RequestBuilder request;
		Customer customer = new Customer(6, "First", "Last", "abc@WIPRO.COM");
		
		when(service.getCustomer("CX1001")).thenReturn(customer);
		
		request=MockMvcRequestBuilders
				.get("/customers/{id}",6)
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
			   .andExpect(status().isOk())
			   .andReturn();
		
	}

}
