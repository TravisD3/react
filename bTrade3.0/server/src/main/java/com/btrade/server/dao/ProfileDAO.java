package com.btrade.server.dao;

import java.util.List;

import com.btrade.server.model.Profile;

public interface ProfileDAO {
	public void saveProfile(Profile profile);
	public void updateProfile(Profile profile);
	public List<Profile> listProfile();
	public Profile getProfileById(int uid_no);
	public boolean deleteProfileById(int uid_no);
}
