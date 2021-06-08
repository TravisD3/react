package com.btrade.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.btrade.server.model.Profile;
/**
 * 在applicationContext.xml中被定义为一个bean, 属性sessionFactory, transactionManager从容器中注入
 *
 */
public class ProfileDAOImpl implements ProfileDAO, InitializingBean 
{
	private HibernateTemplate hibernateTemplate;// 在sessionFactory注入的时候，new了一个HibernateTemplate
	private SessionFactory sessionFactory; //从容器中注入
//	private JtaTransactionManager transactionManager;
	private HibernateTransactionManager txManager;
	
	
	public ProfileDAOImpl()
	{
		System.out.println("*******************生成ProfileDAOImpl的Bean");
	}
	
	public HibernateTemplate getHibernateTemplate() 
	{
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) 
	{
		this.hibernateTemplate = hibernateTemplate;
	}

	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		//System.out.println("IN SET SESSION FACTORY  today " + sessionFactory);
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		//System.out.println("IN SET HIBERNATE TEMPLATE TODAY =" + this.hibernateTemplate);
		System.out.println("***************给ProfileDaoImpl注入SessionFactory*********");
	}

//	public JtaTransactionManager getTransactionManager() 
//	{
//		return transactionManager;
//	}
//
//	public void setTransactionManager(JtaTransactionManager transactionManager)
//	{
//		this.transactionManager = transactionManager;
//	}
	
	//更新档案
	@Override
	public void updateProfile(Profile profile) 
	{
		
		/* hibernateTempalte.saveOrUpdate can only save a new record but cannot
		so I choose seesion, transaction to complete this. */
		Session session = this.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		//尝试使用get？？？？
		Profile oldProfile = (Profile) session.load(Profile.class, profile.getUid_no());

		oldProfile.setAddress1(profile.getAddress1());
		oldProfile.setAddress2(profile.getAddress2());
		oldProfile.setCity(profile.getCity());
		oldProfile.setCountry(profile.getCountry());
		oldProfile.setEmail(profile.getEmail());
		oldProfile.setFirst_name(profile.getFirst_name());
		oldProfile.setLast_name(profile.getLast_name());
		oldProfile.setPhone(profile.getPhone());
		oldProfile.setState(profile.getState());
		oldProfile.setActive(profile.getActive());
		oldProfile.setZip(profile.getZip());

		session.save(oldProfile);
		tx.commit();
		session.close();
	}
	
	//查找出所有的用户档案信息
	@Override
	public List<Profile> listProfile() 
	{
		List<Profile> list = this.hibernateTemplate.find("from Profile");
		return list;
	}
	
	//根据uid_no查找出用户档案
	@Override
	public Profile getProfileById(int uid_no)
	{
		List<Profile> profile = this.hibernateTemplate.find("from Profile profile where profile.uid_no = ?", uid_no);
		if(profile.size() == 0) return null;
		return profile.get(0);
	}
	
	//根据uid_no来删除用户档案
	@Override
	public boolean deleteProfileById(int uid_no) 
	{
		//批量更新
		int numOfRowsDel = this.hibernateTemplate.bulkUpdate("delete Profile profile where profile.uid_no=?", uid_no);
		if (numOfRowsDel == 1)
			return true;
		else
			return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{

	}
	
	
	//添加一个用户档案
	@Override
	public void saveProfile(Profile profile) 
	{
		this.hibernateTemplate.saveOrUpdate(profile);
	}

	public HibernateTransactionManager getTxManager()
	{
		return txManager;
	}

	public void setTxManager(HibernateTransactionManager txManager) 
	{
		this.txManager = txManager;
		System.out.println("***************给ProfileDaoImpl注入TransactionManager*********");
	}
}
