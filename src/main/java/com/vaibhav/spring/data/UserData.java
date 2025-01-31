package com.vaibhav.spring.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
public class UserData {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null){
            this.id = UUID.randomUUID().toString();
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserData(){

    }
}
