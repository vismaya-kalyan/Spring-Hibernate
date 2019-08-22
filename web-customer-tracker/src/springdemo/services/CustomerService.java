package springdemo.services;
import java.util.List;

import springdemo.entity.*;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomers(int theId);

	public List<Customer> searchCustomers(String theSearchName);
}
