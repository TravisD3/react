/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.btrade.server.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAttribute;

import com.btrade.server.Client;
import com.btrade.server.Customer;
import com.btrade.server.model.Task;

/**
 * 在applicationContext.xml中被定义为一个bean, 属性sessionFactory, TransactionManger从容器中注入
 *
 */
public class TaskDAOImpl implements TaskDAO, InitializingBean {

	//private static final String CUSTOMER_INERT_SQL = "INSERT INTO CUSTOMER(ID, FIRSTNAME, LASTNAME)";
	//private static final String CUSTOMER_UPDATE_SQL = "UPDATE CUSTOMER SET ID WHERE ID = ?";
	//private static final String CUSTOMER_DELETE_SQL = "DELETE FROM CUSTOMER WHERE ID = ?";
	private HibernateTemplate hibernateTemplate;// 在注入sessionFactory的时候，new了一个HibernateTemplate
	private SessionFactory sessionFactory; //从applicationContext中注入
	//private JtaTransactionManager transactionManager;
	private HibernateTransactionManager txManager;

	public TaskDAOImpl()
	{
		System.out.println("*******************生成TaskDAOImpl的Bean");
	}

	protected TransactionAttribute findTransactionAttribute(Class UserDAOImpl) {
		TransactionAttribute txAtt = findTransactionAttribute(UserDAOImpl);
		return txAtt;
	}

//	public JtaTransactionManager getTransactionManager() {
//		return transactionManager;
//	}
//
//	public void setTransactionManager(JtaTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}

	public SessionFactory getSess() {
		return sessionFactory;
	}

	public void afterPropertiesSet() {
		System.out.println("inside set properties and after today ");
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		//System.out.println("IN SET SESSION FACTORY  today " + sessionFactory);
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
		//System.out.println("IN SET HIBERNATE TEMPLATE TODAY ="
		//		+ this.hibernateTemplate);
		System.out.println("***************给TaskDaoImpl注入SessionFactory*********");
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	//取一个Customer
	public Customer getCustomer(int st) {

		try {
			Long i = new Long(st);
			Customer cs;
			System.out
					.println("IN saveUser hibernateTemplate  customer before in method found");
			cs = (Customer) this.hibernateTemplate.load(Customer.class, i);//为什么要用load?加载出来只是一个代理类，当真正用的时候才回去数据库拿，
																		  // 当session关闭后，拿就会报错
			return cs;
		} catch (org.hibernate.ObjectNotFoundException e) {
			System.out
					.println("IN saveUser hibernateTemplate  customer not found ex ="
							+ e.toString());
			return null;
		}
	}

	//存放一个任务
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void saveTask(String taskName, String taskDesc, String taskPriority, String taskStatus) {

		Task cs = new Task();
		cs.setTaskName(taskName);
		cs.setTaskDesc(taskDesc);
		cs.setTaskPriority(taskPriority);
		cs.setTaskStatus(taskStatus);
		this.hibernateTemplate.saveOrUpdate(cs);
	}
	
	//存放一个用户，先检查用户是否存在，存在更新，不存在新建
	public void saveUser2(int userId, String firstName, String lastName) 
	{

		saveClient(userId, firstName, lastName);

		Long i = new Long(userId);
		Customer cs;
		try {
			System.out.println("IN saveUser doing load with isol level hibernateTemplate  for customer  = " + i);
			cs = (Customer) this.hibernateTemplate.load(Customer.class, i);
			System.out.println("IN saveUser hibernateTemplate  customer after found cs = " + cs.toString());
		} catch (ObjectNotFoundException e) {
			System.out.println("IN saveUser ObjectNotFoundException  customer today ex =" + e.toString());
			cs = new Customer();
			cs.setId(i);
		} catch (Exception e) {
			System.out.println("IN saveUser Exception  customer not found ex =" + e.toString());
			cs = new Customer();
			cs.setId(i);
		}
		cs.setFirstName(firstName);
		cs.setLastName(lastName);
		System.out.println("IN saveUser hibernateTemplate before saveorupdate new = +++++++++=");

		try {
			this.hibernateTemplate.saveOrUpdate(cs);
			System.out.println("IN saveUser hibernateTemplate after  saveorupdate and before refresh= +++++++++=");
			System.out.println("IN saveUser after flush only today = +++++++++=");

		} catch (StaleObjectStateException e) {
			System.out.println("IN saveUser StaleObjectStateException exception  today= +++++++++=");
		} catch (HibernateOptimisticLockingFailureException r) {
			System.out.println("IN saveUser HibernateOptimisticLockingFailureException exception NEW today= +++++++++=");
		}
	}
	
	//取出所有的用户
	public List<Customer> listUser1(int firstResult, int maxResults) {
		try {
			DetachedCriteria query = DetachedCriteria.forClass(Customer.class);
			// query.s
			System.out.println("IN hib template LISTuser firstResult +++++++++= " + firstResult);
			System.out.println("IN hib template LISTuser maxrow  +++++++++= " + maxResults);
			System.out.println("IN hib template LISTuser hibernateTemplate last one  +++++++++= " + hibernateTemplate);
			List<Customer> l;
			l = this.hibernateTemplate.findByCriteria(query, 1, maxResults);
			return l;
		} catch (Exception e) {
			System.out.println("IN exeption list customer 1 +++++++++= " + e.toString());
			System.out.println("IN exeption list customer 2 +++++++++= " + e.getMessage());
			System.out.println("IN exeption list customer 3 +++++++++= " + e.getLocalizedMessage());
			System.out.println("IN exeption list customer 1 +++++++++= " + e.fillInStackTrace());
			System.out.println("IN exeption list customer 1 +++++++++= " + e.getCause());
			return null;
		}
	}
	
	//？？获得特定用户id的用户？
	public List<Object[]> listUser(String st) 
	{
		Long i = new Long(st);

		List resultUser = this.hibernateTemplate
				.find("select c.id, c.firstName, c.lastName, cl.lastName from Customer c, Client cl where c.id = cl.customerId and c.id = ? ",
						new Object[] { i });

		System.out.println("listUser size = " + resultUser.toString().length());
		return resultUser;
	}
	
	//拿出说有的task
	public List<Task> listTask() 
	{
		return this.hibernateTemplate.find("from Task");
	}

	//拿出所有的用户
	public Iterator listUserDetailIter() 
	{
		System.out.println("IN listUserDetailIter itratot begin= ");
		String sql = " select id, firstName, lastName  from Customer";
		System.out.println("IN listUserDetailIter itratot end new = ");
		Iterator it = this.hibernateTemplate.iterate(sql);
		System.out.println("IN listUserDetailIter itratot end last= " + it);
		return it;
	}
	
	//拿出所有的用户
	@Transactional
	public List<Object[]> listUserDetail() {
		String sql = " select id, FIRSTNAME, LASTNAME , lastName  from CUSTOMER, CLIENT where id = customerId";
		System.out.println("IN LISTDETAIL LAST METHOD session factory 2= "
				+ sessionFactory);
		List<Object[]> ls = sessionFactory.getCurrentSession()
				.createSQLQuery(sql).list();
		return ls;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updUserDetail2(String st, String st1) {
		System.out.println(" ******** INSIDE  updUserDetail2 BEGIN *******=");
	}
	
	//更新用户
	@Transactional(propagation = Propagation.REQUIRED)
	public void updUserDetail(String st, String st1) {
		System.out.println("chris 5555555**** INSIDE  updUserDetail BEGIN best one *******=");
		Integer id = new Integer(st);
		System.out.println("chris 888888888aaaaaaaa id = " + id);
		String par1 = "test firtst name";
		String sql = " select c.id, c.firstName, c.lastName , cl.lastName  from Customer c, Client cl where c.id = cl.customerId ";
		System.out.println("chris 5555555aaaaaaaaaa sql = " + sql);
		String sql1 = "update Customer set firstName = :pr" + " where id = :id";

		// this.hibernateTemplate.update(CUSTOMER_UPDATE_SQL, new Object[]{id});
		System.out.println("chris 666666666666 ");
		Query qwr = (Query) sessionFactory.getCurrentSession().createQuery(sql1);
		System.out.println("chris 777777777777777");
		qwr.setParameter("pr", st1);
		qwr.setInteger("id", id);
		System.out.println("chris 8888888 NamedParameters ");
		int rowCount = qwr.executeUpdate();
		System.out.println("rowCount = " + rowCount);
		//ApplicationContext ctx = AppContext.getApplicationContext();
		System.out.println("before CREATE userDAOImpl1 ");

		// UserDAO userDAOImpl1 = (UserDAO) ctx.getBean("myUserDAO1");
		System.out.println("AFTER CREATE userDAOImpl1 ");

		// userDAOImpl1.updUserDetail1(st1);
		if (st1.equals("2")) {
			System.out.println("AFTER exception new today ^^^^^^^^ = ");
			throw new java.lang.RuntimeException();
		}
		System.out.println("**************  INSIDE  updUserDetail best one END *******=");
	}
	
	//更新用户
	@Transactional(propagation = Propagation.NEVER)
	public void updUserDetail1(String st) {
		Integer id = new Integer(st);
		String sql = " select id, firstName, lastName  from Customer";
		String sql1 = "update Client set first_Name = :pr" + " where customerId = :id";
		Query qwr = (Query) sessionFactory.getCurrentSession().createQuery(sql1);
		qwr.setParameter("pr", "test123456789+");
		qwr.setInteger("id", id);
		System.out.println("query === 2= " + qwr.toString());
		int rowCount = qwr.executeUpdate();
		System.out.println("AFTER UPDATE updUserDetail 1 number of  updated rows ... = " + rowCount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updUserDet(String st, String st1) {
		System.out.println("UserDAOImpl::updUserDet **INSIDE  updUserDet  BEGIN today *******=");
		updUserDetail2(st, st1);
		updUserDetail(st, st1);
		System.out.println("************  INSIDE  updUserDet END *******=");
	}

	public void updUserDet1(String st, String st1) {
		updUserDetail1(st1);
	}

	public void updUserD(String st, String st1, String st2, String st3) {
		updUserDet(st, st1);
		updUserDet1(st2, st3);
	}
	
	//保存客户
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void saveClient(int userId, String firstName, String lastName) {
		Client cs = new Client();
		Integer i = new Integer(userId);
		cs.setCustomerId(i);
		cs.setFirstName(firstName);
		cs.setLastName(lastName);
		this.hibernateTemplate.saveOrUpdate(cs);
	}
	
	//保存一个客户，先查找客户，有的话直接更新，没有的话新建一个
	public void saveClient2(int userId, String firstName, String lastName)
	{
		Integer i = new Integer(userId);
		Client cs;
		try {
			System.out.println("IN saveUser doing load with isol level hibernateTemplate  for customer  = " + i);
			cs = (Client) this.hibernateTemplate.load(Client.class, i);
			System.out.println("IN saveUser hibernateTemplate  customer after found cs = " + cs.toString());
		} catch (ObjectNotFoundException e) {
			System.out.println("IN saveUser ObjectNotFoundException  customer today ex =" + e.toString());
			cs = new Client();
			cs.setCustomerId(i);
		} catch (Exception e) {
			System.out.println("IN saveUser Exception  customer not found ex =" + e.toString());
			cs = new Client();
			cs.setCustomerId(i);
		}
		cs.setFirstName(firstName);
		cs.setLastName(lastName);
		System.out.println("IN saveUser hibernateTemplate before saveorupdate new = +++++++++=");

		try {

			this.hibernateTemplate.saveOrUpdate(cs);
			System.out.println("IN saveUser hibernateTemplate after  saveorupdate and before refresh= +++++++++=");
			System.out.println("IN saveUser after flush only today = +++++++++=");

		} catch (StaleObjectStateException e) {
			System.out.println("IN saveUser StaleObjectStateException exception  today= +++++++++=");
		} catch (HibernateOptimisticLockingFailureException r) {
			System.out.println("IN saveUser HibernateOptimisticLockingFailureException exception NEW today= +++++++++=");
		}
	}

	public HibernateTransactionManager getTxManager() 
	{
		return txManager;
	}

	public void setTxManager(HibernateTransactionManager txManager)
	{
		this.txManager = txManager;
		System.out.println("***************给TaskDaoImpl注入TransactionManager*********");
	}
}
