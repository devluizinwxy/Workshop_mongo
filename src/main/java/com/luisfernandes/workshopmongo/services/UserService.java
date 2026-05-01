package com.luisfernandes.workshopmongo.services;

import com.luisfernandes.workshopmongo.domain.User;
import com.luisfernandes.workshopmongo.dto.UserDto;
import com.luisfernandes.workshopmongo.dto.UserDtoRequest;
import com.luisfernandes.workshopmongo.repository.UserRepository;
import com.luisfernandes.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuario não existe"));
    }
    public User insert(UserDtoRequest dto){
     User user = fromDto(dto);
     return userRepository.insert(user);
    }
    public User fromDto(UserDtoRequest dto){
        User user = new User(null,dto.getName(),dto.getEmail());
        return user;
    }
  public void delete(String id){
        if (!userRepository.existsById(id)){
            throw new ObjectNotFoundException("User não encontrado");
        }
      userRepository.deleteById(id);
  }
  public User update(String id,UserDto userDto){
      User entity = userRepository.findById(id)
              .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
      updateData(entity,userDto);
      return userRepository.save(entity);

  }
  public void updateData(User user, UserDto userDto){
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

  }
}
