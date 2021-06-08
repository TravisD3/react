package com.btrade.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btrade.server.model.Profile;
import com.btrade.server.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile getProfile(Integer id) {

		Profile profile = profileRepository.getOne(id);
		return profile;
	}

	@Override
	public void save(Profile profile) {
		profileRepository.save(profile);
	}

}