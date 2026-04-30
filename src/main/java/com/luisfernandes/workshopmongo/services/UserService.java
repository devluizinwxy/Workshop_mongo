package com.luisfernandes.workshopmongo.services;

import com.luisfernandes.workshopmongo.domain.User;
import com.luisfernandes.workshopmongo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<User> findAll(){
        List<User> userList = userRepository.findAll();

        return userList;
    }
    @PostConstruct
    public void debug() {
        System.out.println("CLASS: " + userRepository.getClass());
        System.out.println("COUNT: " + userRepository.count());
    }
}
