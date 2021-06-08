package com.btrade.server.service;

import com.btrade.server.model.User;
import com.btrade.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service("userService")
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void updateUser(User theUser, Long id) {
        userRepository.findById(id).map(user -> {
            user.setPassword(theUser.getPassword());
            return userRepository.save(user);
        });
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String name) {
        return userRepository.getUserByUsername(name);
    }

    public List<User> findUsersWithPartOfName(String userName) {
        return userRepository.findUsersWithPartOfName(userName);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
