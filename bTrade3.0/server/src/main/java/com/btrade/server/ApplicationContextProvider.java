/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.btrade.server;

/**
 *	不知道这个类用来干什么， 没有用到 
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware 
{

    public void setApplicationContext(ApplicationContext ctx) throws BeansException 
    {
        System.out.println("ApplicationContextProvider CTX = " + ctx );
       // AppContext.setApplicationContext(ctx);
    }
    
    public ApplicationContextProvider()
    {
    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ApplicationContextProvider????????????????????");
    }
    
}
