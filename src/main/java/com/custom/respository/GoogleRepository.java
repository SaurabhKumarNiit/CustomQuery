package com.custom.respository;

import com.custom.enties.Customer;
import com.custom.enties.GoogleLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoogleRepository extends CrudRepository<GoogleLogin, String> {
    GoogleLogin findByEmail(String email);
}
