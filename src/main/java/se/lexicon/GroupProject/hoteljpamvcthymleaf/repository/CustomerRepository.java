package se.lexicon.GroupProject.hoteljpamvcthymleaf.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    List<Customer> findAll();
    List<Customer> findAllByCustomerFirstNameContainingIgnoreCase(String customerFirstName);
    List<Customer> findAllByCustomerLastNameContainingIgnoreCase(String customerLastName);
    List<Customer> findAllByCustomerEmailContainingIgnoreCase(String customerEmail);
    Customer findByCustomerId(String customerId);
}
