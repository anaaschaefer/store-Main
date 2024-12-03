package com.cupcake_store.store.services;

import com.cupcake_store.store.entities.User;
import com.cupcake_store.store.entities.dtos.UserDTO;
import com.cupcake_store.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO login(String username, String password) {
        User user = userRepository.findByEmailAndPassword(username, password);
        if (user != null) {
            return UserDTO.builder()
                    .address(user.getAddress())
                    .email(user.getEmail())
                    .id(user.getId())
                    .phone(user.getPhone())
                    .userType(user.getUserType())
                    .username(user.getUsername())
                    .build();
        }
        return null;
    }
}
