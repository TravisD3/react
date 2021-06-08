package com.btrade.server;

import org.hibernate.SessionFactory;
/**
 * 在applicationContext.xml用定义使用
 *
 */
public class HibernateUtil 
{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) 
    {
        this.sessionFactory = sessionFactory;
        System.out.println("***********给HibernateUtil注入SessionFactory********");
    }

    public SessionFactory getSessionFactory() 
    {
        return this.sessionFactory;

    }
    
    public HibernateUtil()
    {
    	System.out.println("*********************生成HibernateUtil的Bean******");
    }
}