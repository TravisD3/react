package com.btrade.server.service;

import java.util.Collection;
import java.util.List;

import com.btrade.server.model.Homeland;
import com.btrade.server.model.NewProfile;

public interface NewProfileService {

	public Collection<NewProfile> profileList();
	public  NewProfile getDetails(long id);
	
	public NewProfile updateInfos(NewProfile sub);
	public NewProfile add(NewProfile sub);
	public void delete(NewProfile sub);
	public List<Homeland> getCountrySymbol(String name);
	public NewProfile getProfileByUserId(long userId);
}
