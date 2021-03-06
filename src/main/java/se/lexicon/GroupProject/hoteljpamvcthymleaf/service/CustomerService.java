package se.lexicon.GroupProject.hoteljpamvcthymleaf.service;

import se.lexicon.GroupProject.hoteljpamvcthymleaf.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO findById(String customerId);
    CustomerDTO findByEmail(String customerEmail);
    List<CustomerDTO> findAll();
    CustomerDTO create(CustomerDTO customerDTO);
    CustomerDTO update(CustomerDTO customerDTO);
    boolean delete(String customerId);
}
