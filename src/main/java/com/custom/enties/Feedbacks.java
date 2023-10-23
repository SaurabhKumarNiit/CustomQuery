package com.custom.enties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Feedbacks {

    @Id
    private String email;

    private String rating;

    private String experience;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Feedbacks(String email, String rating, String experience) {
        this.email = email;
        this.rating = rating;
        this.experience = experience;
    }

    public Feedbacks() {
    }

    @Override
    public String toString() {
        return "Feedbacks{" +
                "email='" + email + '\'' +
                ", rating='" + rating + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
