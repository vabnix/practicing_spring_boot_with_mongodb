package com.vaibhav.spring.services;

import com.vaibhav.spring.data.UserData;
import com.vaibhav.spring.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserData createUser(UserData userData) {
        if (userData != null) {
            userData.setId(UUID.randomUUID().toString());
            return userRepository.save(userData);
        } else {
            return null;
        }
    }

    public List<UserData> getAllUsers() {
        return userRepository.findAll();
    }

    public UserData getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public UserData updateUserById(String id, UserData userData) {
        UserData user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(userData.getFirstName());
            user.setLastName(userData.getLastName());
            user.setLocation(userData.getLocation());
            return userRepository.save(user);
        } else {
            return null;
        }
    }
}
