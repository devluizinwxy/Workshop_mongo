package com.luisfernandes.workshopmongo.resource;

import com.luisfernandes.workshopmongo.domain.User;
import com.luisfernandes.workshopmongo.dto.UserDto;
import com.luisfernandes.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> users =  userService.findAll();
        List<UserDto> dtos = users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtos);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id){
        User user = userService.findById(id);
        UserDto userDto = new UserDto(user);
        return  ResponseEntity.ok().body(userDto);
    }
}
