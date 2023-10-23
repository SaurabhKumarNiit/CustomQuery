package com.custom.Service;

import com.custom.enties.GoogleLogin;
import com.custom.exception.CustomerNotFoundException;
import com.custom.respository.GoogleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoogleService {

    @Autowired
    GoogleRepository googleRepository;

    public GoogleLogin addUser(GoogleLogin googleLogin) {

        return googleRepository.save(googleLogin);
    }

    public GoogleLogin saveUserCredential(GoogleLogin userCredential) {
//        Optional<GoogleLogin> existingUser = googleRepository.findById(userCredential.getId());
        GoogleLogin googleLogin = googleRepository.save(userCredential);

        return googleLogin;

        // You can add additional logic if needed
    }

    public List<GoogleLogin> getAllUserCredentials() {

        return (List<GoogleLogin>) googleRepository.findAll();
    }

    public GoogleLogin getUserCredentialsByEmail(String email) throws CustomerNotFoundException {

        return googleRepository.findByEmail(email);
    }

}
