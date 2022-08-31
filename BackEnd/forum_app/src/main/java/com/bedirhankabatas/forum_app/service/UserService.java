package com.bedirhankabatas.forum_app.service;

import com.bedirhankabatas.forum_app.entities.Users;
import com.bedirhankabatas.forum_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Users getOneUserById(Long id) {
        return  userRepository.findById(id).orElse(null);
    }
    public Users createUser(Users users) {
        return userRepository.save(users);
    }
    public void deleteUser(Long id) {
    userRepository.deleteById(id);
    }
    public Users updateUser(Long id, Users newUser) {
        Optional<Users> user = userRepository.findById(id);
        if(user.isPresent()){
            Users foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            return userRepository.save(foundUser);
        }else{
            return  null;
        }
    }


}

