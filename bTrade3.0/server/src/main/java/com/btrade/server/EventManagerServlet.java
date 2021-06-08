package com.btrade.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.btrade.server.dao.TaskDAO;
import com.btrade.server.model.Task;

public class EventManagerServlet extends HttpServlet 
{

	/**
	 * 在web.xml中被定义使用
	 */
	private static final long serialVersionUID = 1L;
	WebApplicationContext springContext;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

		try {
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Event Manager</title></head><body>");
			//System.out.println("EventManagerServlet RADIO BUTTOM = "
			//		+ request.getParameter("group1"));
			printEventForm(out);
			listEvents(out, dateFormatter, request);
			out.println("</body></html>");
			out.flush();
			out.close();
			System.out.println("End of try block in EventManagerServlet ");
		} catch (Exception ex) {
			if (ServletException.class.isInstance(ex)) {
				System.out.println("in exceptio +++++++++=");
				throw (ServletException) ex;
			} else {
				throw new ServletException(ex);
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void printEventForm(PrintWriter out) {
		out.println("<h2>List of Tasks</h2>");
	}

	private void listEvents(PrintWriter out, SimpleDateFormat dateFormatter, HttpServletRequest request) 
	{
		try 
		{

			//String userId = request.getParameter("userId");
			String taskName = request.getParameter("taskName");
			String taskDesc = request.getParameter("taskDesc");
			String taskPriority = request.getParameter("taskPriority");
			String taskStatus = request.getParameter("taskStatus");

			//if (userId != null)
				//userId = userId.trim();

			TaskDAO taskDAO = (TaskDAO) springContext.getBean("myTaskDAO");

			taskDAO.saveTask(taskName, taskDesc, taskPriority, taskStatus);
			List<Task> list = taskDAO.listTask();

			out.println("The total # of client is: " + list.size() + "<br><br>");
			out.println("Task ID" + "\t" + "Task Name" + "\t" + "Task Description" + "\t" + "Task Priority" + "\t" +"Task Status" + "<br>");

			for (Task c : list) {
				out.println(c.getTaskId() + "\t" + c.getTaskName() + "\t"
						+ c.getTaskDesc() + "\t" + c.getTaskPriority()+ "\t" + c.getTaskStatus()+"<br>");
			}

		} catch (Exception ex) {
			System.out.println("INSIDE main SQL EXCEPTION +****="
					+ ex.toString());
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		springContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		System.out.println("---------------程序第四步，读取web.xml内容 然后加载EventManagerServlet，在这里springContext已经赋值，可以拿到applicationContext.xml配置的bean-------");
	}
}
