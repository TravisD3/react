package com.btrade.server.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Role;
import com.btrade.server.model.RoleName;
import com.btrade.server.model.User;
import com.btrade.server.repository.RoleRepository;
import com.btrade.server.service.UserService;

//@CrossOrigin(origins = {"http://localhost:4200", "http://18.188.198.196:4200", "http://172.31.5.57:4200"}, maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController
{
    private UserService userService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	RoleRepository roleRepository;
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PutMapping(value="/update/{id}", headers = "Accept=application/json")
    public void updateUser(@RequestBody User theUser, @PathVariable Long id) {
//    	SLiu should we encode password here? 
//    	Must, since updateUser did not have encode method, so we need to encrypt before 
    	theUser.setPassword(encoder.encode(theUser.getPassword()));

        userService.updateUser(theUser, id);
    }

    @GetMapping(value = "/users", headers = "Accept=application/json")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @PostMapping(value="/search-by-name", headers = "Accept=application/json")
    public List<User> findUsersWithPartOfName(@RequestBody String userName) {
        return userService.findUsersWithPartOfName(userName);
    }

    @GetMapping(value="/search-by-id/{id}", headers = "Accept=application/json")
    public List<User> findUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return Arrays.asList(user);
        } else {
            return new ArrayList<>();
        }
    }

    @PostMapping(value="/add", headers = "Accept=application/json")
    public User addUser(@RequestBody User user) {
    	// SLiu encode password;
    	user.setPassword(encoder.encode(user.getPassword()));
//    	2020-09-16, Siyu Liu, modify 'add' method to give role to these users added by this method  
    	// default, we only add 'user' in this method
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		roles.add(userRole);		
		user.setRoles(roles);
    	
        return userService.addUser(user);
    }

    @DeleteMapping(value = "/delete/{id}", headers = "Accept=application/json")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
