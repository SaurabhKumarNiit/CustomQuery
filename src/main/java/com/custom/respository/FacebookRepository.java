package com.custom.respository;


import com.custom.enties.FacebookLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookRepository extends CrudRepository<FacebookLogin,String> {

    FacebookLogin findByEmail(String email);
}
