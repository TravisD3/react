package com.btrade.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.btrade.server.dao.TaskDAO;
import com.btrade.server.model.Task;

/**
 * Servlet implementation class TestServlet
 * 这个类用于加载rootContext用于给DAO，Service层拿到容器中定义的bean 在web.xml中被定义
 */
@WebServlet("/TestServlet")
public class GetSpringContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = Logger.getLogger(GetSpringContextServlet.class);

	// webApplicationContext继承自ApplicationContext,ApplicationContext在容器启动后会存放在servletContext
	public static WebApplicationContext rootContext;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetSpringContextServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext container = request.getSession().getServletContext();
		container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
				.addMappingForUrlPatterns(null, false, "/*");

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Event Manager</title></head><body>");
		// System.out.println("EventManagerServlet RADIO BUTTOM = "
		// + request.getParameter("group1"));
		TaskDAO taskDAO = (TaskDAO) rootContext.getBean("myTaskDAO");
		List<Task> list = taskDAO.listTask();
		out.println("</body></html>");
		out.println("The total # of client is: " + list.size() + "<br><br>");
		out.println("Bingo! Bingo!" + "<br><br>");
		out.println("Task ID" + "\t" + "Task Name" + "\t" + "Task Description" + "\t" + "Task Priority" + "\t"
				+ "Task Status" + "<br>");

		for (Task c : list) {
			out.println(c.getTaskId() + "\t" + c.getTaskName() + "\t" + c.getTaskDesc() + "\t" + c.getTaskPriority()
					+ "\t" + c.getTaskStatus() + "<br>");
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// 这个Context取的是WebApplicationContext也叫rootContext, 每个web项目中只有一个，也就是Spring
		// IOC容器，是其他servlet自己创建的context
		// 的父容器
		rootContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		// test1
		// System.out.println("rootContext: "+rootContext);
		
		logger.info("End of GetSpringContextServlet:init");
		// ---------------程序第四步，读取web.xml内容 然后加载GetSpringContextServlet，在这里rootContext已经赋值，可以拿到applicationContext.xml配置的bea-------
	}

}
