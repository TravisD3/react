package com.siyu.myhealthapp.service;


import com.siyu.myhealthapp.module.User;
import com.siyu.myhealthapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {

    private UserRepository userRepository;

    @Autowired
    private void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * C
     * @param user
     */
    public void add(User user){
        userRepository.save(user);
    }

    /**
     * R
     * @return
     */
    public List<User> getAll(){
        return userRepository.findAll();
    }

    /**
     * U
     * @param user
     */
    public void update(User user){
        userRepository.findById(user.getId()).map(user1 -> {
            user1.setPassword(user.getPassword());
            return userRepository.save(user1);
        });
    }

    /**
     * D
     * @param id
     */

    public void delete(Integer id){
        userRepository.deleteById(id);
    }

    public User Login(String username, String password){

        return userRepository.logInName(username,password);
    }
}
