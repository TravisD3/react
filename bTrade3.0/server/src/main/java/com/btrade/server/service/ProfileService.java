package com.btrade.server.service;

import com.btrade.server.model.Profile;

public interface ProfileService {

	public Profile getProfile(Integer id);

	public void save(Profile profile);

}
