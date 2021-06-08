package com.btrade.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.GeneralException;
import com.btrade.server.model.Profile;
import com.btrade.server.service.ProfileService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/profile")
public class ProfilesController {
//	ProfileService profileService = new ProfileService();
	@Autowired
	private ProfileService profileService;

	/*
	 * This API needs to be checked after reading through the frontend angularjs
	 * part
	 */
	@RequestMapping(value = "/{uid_no}/update/{last_name}/{first_name}/{email}/{phone}/{active}/{address1}/{address2}/{city}/{state}/"
			+ "/{country}/{zip}", method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean updateProfile(@PathVariable String uid_no, @PathVariable String last_name,
			@PathVariable String first_name, @PathVariable String email, @PathVariable String phone,
			@PathVariable String active, @PathVariable String address1, @PathVariable String address2,
			@PathVariable String city, @PathVariable String state, @PathVariable String country,
			@PathVariable String zip) {

		Profile profile = new Profile();
		profile.setUid_no(Integer.parseInt(uid_no));
		profile.setActive(active.charAt(0));
		profile.setAddress1(address1);
		profile.setAddress2(address2);
		profile.setCity(city);
		profile.setState(state);
		profile.setCountry(country);
		profile.setFirst_name(first_name);
		profile.setLast_name(last_name);
		profile.setPhone(phone);
		profile.setEmail(email);
		profile.setZip(zip);
		try {
			//profileService.updateProfile(profile);
			System.out.println("The profile " + profile.getUid_no() + " modification is saved.");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * This API needs to be checked after reading through the frontend angularjs
	 * part
	 */
	@RequestMapping(value = "/{uid_no}/update/{last_name}/{first_name}/{email}/{phone}/{active}/{address1}/{address2}", method = RequestMethod.POST, headers = "Accept=application/json")
	public boolean updateTestProfile(@PathVariable String uid_no, @PathVariable String last_name,
			@PathVariable String first_name, @PathVariable String email, @PathVariable String phone,
			@PathVariable String active, @PathVariable String address1, @PathVariable String address2) {

		try {
			System.out.println("Profile " + uid_no + "  " + address1 + " is saved.");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Query profile list and return it to front end as json
	 */

	@RequestMapping(value = "/profiles", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Profile> listProfile() {

		System.out.println("In List all Profile");
		List<Profile> list = null;
		//list = profileService.listProfile();
		System.out.println("Get tasks=" + list);
		return list;
	}

	/*
	 * Query profile with the specified uid_no.
	 */

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	Profile getProfileById(@PathVariable int id) {
		System.out.println("In getProfileById");
		try {
			Profile profile = profileService.getProfile(id);
			System.out.println("profile = " + profile);
			return profile;
		} catch (Exception e) {
			throw new GeneralException("The id " + id + " profile doesn't exist.");
		}

	}

	/*
	 * Delete profile with the specified uid_no
	 */
	@RequestMapping(value = "/{uid_no}/delete", method = RequestMethod.GET, headers = "Accept=application/json")
	public boolean deleteProfileById(@PathVariable int uid_no) {
		System.out.println("In Delete ProfileById");
		boolean result = false;
		//result = profileService.deleteProfileById(uid_no);
		if (result) {
			return true;
		} else {
			throw new GeneralException("The uid_no " + uid_no + " profile doesn't exist");
		}
	}

}
