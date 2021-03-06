package se.lexicon.GroupProject.hoteljpamvcthymleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.dto.CustomerDTO;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.entity.Customer;
import se.lexicon.GroupProject.hoteljpamvcthymleaf.repository.CustomerRepository;



import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

    public class CustomerServiceImpl implements CustomerService {
        CustomerRepository customerRepo;

        @Autowired
        public CustomerServiceImpl(CustomerRepository customerRepo) {
            this.customerRepo = customerRepo;
        }

        @Override
        public CustomerDTO findById(String customerId) {
            if (customerId == null || customerId.equals(""))
                throw new IllegalArgumentException("Customer Id is necessary");
            CustomerDTO dto = new CustomerDTO(customerRepo.findByCustomerId(customerId));
            return dto;
        }

        @Override
        public CustomerDTO findByEmail(String customerEmail) {
            if (customerEmail == null || customerEmail.equals(""))
                throw new IllegalArgumentException("Email is necessary");
            CustomerDTO dto = new CustomerDTO(customerRepo.findByCustomerId(customerEmail));
            return dto;
        }

        @Override
        public List<CustomerDTO> findAll() {
            List<Customer> foundItems = customerRepo.findAll();
            return CustomerDTO.toCustomerDto(foundItems);
        }

        @Override
        public CustomerDTO create(CustomerDTO customerDTO) {
            if (customerDTO.getEmail() == "0")
                throw new RuntimeException("Customer id is invalid");
            if (customerRepo.findByCustomerId(customerDTO.getCustomerId()).isAvailable())
                throw new RuntimeException("Duplication exist in customer");
            Customer customer = new Customer(customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getEmail(), customerDTO.getBookingDate());
            customer.setAvailable(customerRepo.findByCustomerId(customerDTO.getCustomerId()).isAvailable());
            customer.setAvailable(customer.isAvailable());
            return new CustomerDTO(customerRepo.save(customer));
        }

        @Override
        @Transactional
        public CustomerDTO update(CustomerDTO customerDTO) {
            Optional<Customer> optionalCustomer = customerRepo.findById(customerDTO.getCustomerId());
            if (!optionalCustomer.isPresent())
                throw new RuntimeException("customer doesn't exist");
            Customer toUpdated = optionalCustomer.get();
            if (!toUpdated.getCustomerFirstName().equals(customerDTO.getFirstName()))
                toUpdated.setCustomerFirstName(customerDTO.getFirstName());
            if (toUpdated.isAvailable())
                toUpdated.setAvailable(customerDTO.isAvailable());
            if (toUpdated.isAvailable() != customerDTO.isAvailable())
                toUpdated.setAvailable(customerDTO.isAvailable());
            if (toUpdated.getCustomerLastName() != customerDTO.getLastName())
                toUpdated.setCustomerLastName(customerDTO.getLastName());
            if (toUpdated.getCustomerEmail() != customerDTO.getEmail())
                toUpdated.setCustomerEmail(customerDTO.getEmail());
            return new CustomerDTO(customerRepo.save(toUpdated));
        }

        @Override
        public boolean delete(String customerId) {
            if (!customerRepo.findById(customerId).isPresent())
                throw new RuntimeException("There is no customer with id: " + customerId);
            boolean deleted = false;
            if (customerRepo.existsById(customerId)) {
                customerRepo.delete(customerRepo.findById(customerId).get());
                deleted = true;
            }
            return deleted;
        }
    }
