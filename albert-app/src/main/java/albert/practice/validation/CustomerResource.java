package albert.practice.validation;

import com.google.inject.Guice;
import com.google.inject.Inject;

public class CustomerResource {

	@Inject
	private CustomerService service;
	
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setId(null);
		customer.setAge(12);
		customer.setEmail("test@gmail.");
		
		new CustomerResource().createCustomer(customer);
	}
	
	public void createCustomer(Customer customer){
		service = Guice.createInjector().getInstance(CustomerService.class);
		service.create(customer);
	}
	
}
