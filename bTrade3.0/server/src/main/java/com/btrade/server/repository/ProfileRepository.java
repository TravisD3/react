package com.btrade.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.btrade.server.model.Profile;

@Component
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
