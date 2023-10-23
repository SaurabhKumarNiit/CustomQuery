package com.custom.Service;

import com.custom.enties.Customer;
import com.custom.exception.CustomerNotFoundException;
import com.custom.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer findByEmailAndPassword(String email, String password)throws CustomerNotFoundException {
        Customer customer = customerRepository.findByEmailAndPassword(email, password);
        if (customer == null){
            throw new CustomerNotFoundException();
        }
        return customer;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


}
