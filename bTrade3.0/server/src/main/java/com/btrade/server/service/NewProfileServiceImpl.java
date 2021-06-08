package com.btrade.server.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btrade.server.model.Homeland;
import com.btrade.server.model.NewProfile;
import com.btrade.server.repository.NewProfileRepository;
import com.btrade.server.wn.CountryName;

@Service
public class NewProfileServiceImpl implements NewProfileService {

	@Autowired
	private NewProfileRepository profileRepository;

	@Override
	public Collection<NewProfile> profileList() {
		return profileRepository.findAll().stream().collect(Collectors.toList());
	}

	public NewProfile getDetails(long id) {
		return profileRepository.getOne(id);
	}

	public NewProfile getProfileByUserId(long userId) {
		return profileRepository.getProfileByUserId(userId);
	}
	
	public NewProfile updateInfos(NewProfile sub) {
		profileRepository.save(sub);
		return sub;
	}

	public NewProfile add(NewProfile sub) {

		profileRepository.save(sub);
		return sub;
	}

	public void delete(NewProfile sub) {

		profileRepository.delete(sub);
	}

	@Override
	public java.util.List<Homeland> getCountrySymbol(String name) {

		return CountryName.getCountrySymbol(name);

	}

}
