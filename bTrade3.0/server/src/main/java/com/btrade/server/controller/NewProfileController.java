package com.btrade.server.controller;

import java.util.Collection;
import java.util.List;


import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Homeland;
import com.btrade.server.model.NewProfile;
import com.btrade.server.service.NewProfileService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
class NewProfileController {

	private static final Logger log = Logger.getLogger(NewProfileController.class);

	@Autowired
	private NewProfileService profileService;

	@Autowired(required = true)
	public NewProfileController(NewProfileService profileService) {
		this.profileService = profileService;
	}

	// public CoolCarController(CarRepository repository) {
	// this.repository = repository;
	// }

	@GetMapping("/cool-profiles")
	public Collection<NewProfile> profileList() {
		return profileService.profileList();
	}
	
	@GetMapping(path = {"/profiles/{id}"})
    public NewProfile getProfile(@PathVariable(value = "id") String id)  {
		// RZX 2020-09-12 Get profile by user id
		long userId = Long.parseLong(id);
    	//return profileService.getDetails(id);
		NewProfile profile = profileService.getProfileByUserId(userId);
		if (profile != null)
			return profile;
		else
			return new NewProfile();
    }
	
	//update
	@PutMapping(path = {"/profile-edit/{id}"})
    public NewProfile updateChange(@PathVariable(value = "id") String id, @RequestBody NewProfile newProfile)  {
		long userId = Long.parseLong(id);
		log.debug("userId: " + id);
		newProfile.setUserId(userId);
		log.debug("newProfile: " + newProfile.getId() + ", " + newProfile.getFirst_name());
		//return profileService.updateInfos(sub, curr);
		return profileService.updateInfos(newProfile);
    }
	
	//add new
	@PostMapping(path = {"/profiles"})
    public NewProfile addChange(@RequestBody NewProfile sub)  {

		return profileService.add(sub);	
    }
	
	//delete
	@DeleteMapping(path = {"/profile-edit/{id}"})
    public void deleteChange(@PathVariable(value = "id") String id)  {
		long name = Long.parseLong(id);
		NewProfile curr = profileService.getDetails(name);
		profileService.delete(curr);	

    }

	@GetMapping(path = { "/countrySymbol/{country_symbol}" })
	public List<Homeland> getCountrySymbol(@PathVariable("country_symbol") String country_symbol) {
		return profileService.getCountrySymbol(country_symbol);
	}
}