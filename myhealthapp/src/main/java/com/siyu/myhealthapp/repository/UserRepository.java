package com.siyu.myhealthapp.repository;

import com.siyu.myhealthapp.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Boolean existsUserByEmail(String email);

    Boolean existsUserByUserName(String userName);


    @Query("select u from User u where u.userName = :username")
    User getUserByUserName(@Param("username") String username);

    @Query("select u from User u where u.userName = :username and u.password = :password")
    User logInName(@Param("username") String username,
                   @Param("password") String password);

    @Query("select u from User u where u.email = :email and u.password = :password")
    User logInEmail(@Param("email") String email,
                   @Param("password") String password);


}
