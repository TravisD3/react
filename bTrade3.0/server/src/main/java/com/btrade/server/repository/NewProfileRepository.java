package com.btrade.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.btrade.server.model.NewProfile;

@Component
public interface NewProfileRepository extends JpaRepository<NewProfile, Long> {
	
	@Query("SELECT p FROM NewProfile p WHERE p.userId = :userId")
	NewProfile getProfileByUserId(@Param("userId") Long userId);
}
