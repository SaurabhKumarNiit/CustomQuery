package com.custom.enties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GoogleLogin {

    @Id
    private String id;
    private String email;
    private String name;
    private String photoUrl;


    public GoogleLogin(String id, String email, String name, String photoUrl) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public GoogleLogin() {
    }



    public String getId() {
        return id;
    }

    public void setId(String googleUserId) {
        this.id = googleUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "GoogleLogin{" +
                ", googleUserId='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
