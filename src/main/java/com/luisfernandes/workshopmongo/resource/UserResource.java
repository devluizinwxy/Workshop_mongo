package com.luisfernandes.workshopmongo.resource;

import com.luisfernandes.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = new ArrayList<>();
        User Maria = new User("1001", "Maria Brown", "maria@gmail.com");
        User Alex = new User("1002", "Alex Green", "alex@gmail.com");
        users.addAll(Arrays.asList(Maria,Alex));
        return ResponseEntity.ok().body(users);

    }
}
