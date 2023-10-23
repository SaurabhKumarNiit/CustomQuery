package com.custom.respository;

import com.custom.enties.Feedbacks;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedbacks,String> {
    Feedbacks findByEmail(String email);
}
