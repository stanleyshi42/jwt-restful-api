package com.example.jwt_restful_api.service;

import com.example.jwt_restful_api.entity.Customer;
import com.example.jwt_restful_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Customer> customerDetail = repo.findByUsername(username);

        // Convert customerDetail to UserDetails
        return customerDetail.map(CustomerDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found: " + username));
    }

    public Customer addCustomer(Customer customer) {
        customer.setPassword(encoder.encode(customer.getPassword()));
        return repo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public void deleteCustomerById(int id) {
        repo.deleteById(id);
    }

}

