package com.btrade.server.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.btrade.server.dao.ProfileDAO;
import com.btrade.server.model.Profile;
import com.btrade.server.servlet.GetSpringContextServlet;

@Transactional
public class ProfileServiceOld 
{
	WebApplicationContext springContext;
	ProfileDAO profileDAO;
	
	//因为在第四步读取web.xml的时候已经将web.xml中定义的servlet加载(调用其init()方法)完成-->这时候rootContext已经赋值，可以拿到容器中的bean
	public void updateProfile(Profile profile){
		springContext = GetSpringContextServlet.rootContext;
		profileDAO = (ProfileDAO) springContext.getBean("myProfileDAO");
		profileDAO.updateProfile(profile);
	}
	
	public void saveProfile(Profile profile){
		springContext = GetSpringContextServlet.rootContext;
		profileDAO = (ProfileDAO) springContext.getBean("myProfileDAO");
		profileDAO.saveProfile(profile);
	}
	
	public List<Profile> listProfile() {
		springContext = GetSpringContextServlet.rootContext;
		ProfileDAO profileDAO = (ProfileDAO) springContext.getBean("myProfileDAO");
		return profileDAO.listProfile();
	}
	
	public Profile getProfileById(int uid_no) {
		springContext = GetSpringContextServlet.rootContext;
		profileDAO = (ProfileDAO) springContext.getBean("myProfileDAO");
		return profileDAO.getProfileById(uid_no);
	}
	
	
	public boolean deleteProfileById(int uid_no) {
		springContext = GetSpringContextServlet.rootContext;
		profileDAO = (ProfileDAO) springContext.getBean("myProfileDAO");
	    return profileDAO.deleteProfileById(uid_no);
	}
}
