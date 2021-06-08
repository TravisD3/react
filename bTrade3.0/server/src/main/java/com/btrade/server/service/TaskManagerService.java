package com.btrade.server.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.btrade.server.dao.TaskDAO;
import com.btrade.server.model.Task;
import com.btrade.server.servlet.GetSpringContextServlet;

@Transactional
public class TaskManagerService {
		
	
	//因为在第四步读取web.xml的时候已经将web.xml中定义的servlet加载(调用其init()方法)完成-->这时候rootContext已经赋值，可以拿到容器中的bean
	public List<Task> getAllTasks() {

		WebApplicationContext springContext = GetSpringContextServlet.rootContext;

		// test2
		//System.out.println("springContext: " + springContext);
		TaskDAO taskDAO = (TaskDAO) springContext.getBean("myTaskDAO");
		List<Task> list = taskDAO.listTask();
		return list;

	}

}