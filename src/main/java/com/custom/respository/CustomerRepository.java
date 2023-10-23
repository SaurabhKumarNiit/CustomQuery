package com.custom.respository;

import com.custom.enties.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    public Customer findByEmailAndPassword(String email, String password);
}
