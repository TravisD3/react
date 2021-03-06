package com.btrade.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.btrade.server.model.Task;
import com.btrade.server.service.TaskManagerService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TaskManagerController 
{

	TaskManagerService taskmanagerservice = new TaskManagerService();

	@RequestMapping(value = "/tasks", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Task> getAllTasks() 
	{
		List<Task> tasks = taskmanagerservice.getAllTasks();
		System.out.println("Get tasks=" + tasks);
		return tasks;

	}

/*	@RequestMapping(value = "/tasks/archive/{taskIds}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> archiveAllTasks(@PathVariable int[] taskIds) {
		for (int i = 0; i < taskIds.length; i++) {
			taskmanagerservice.archiveTask(taskIds[i]);

		}
		List<Task> tasks = taskmanagerservice.getAllTasks();
		return tasks;

	}

	@RequestMapping(value = "/tasks/{taskId}/{taskStatus}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> changeTaskStatus(@PathVariable int taskId, @PathVariable String taskStatus)
			throws ParseException {
		taskmanagerservice.changeTaskStatus(taskId, taskStatus);
		return taskmanagerservice.getAllTasks();

	}

	@RequestMapping(value = "/tasks/insert/{taskName}/{taskDesc}/{taskPriority}/{taskStatus}", method = RequestMethod.POST, headers = "Accept=application/json")
	public List<Task> addTask(@PathVariable String taskName, @PathVariable String taskDesc,
			@PathVariable String taskPriority, @PathVariable String taskStatus) throws ParseException {
		Task task = new Task();
		task.setTaskName(taskName);
		task.setTaskDescription(taskDesc);
		task.setTaskPriority(taskPriority);
		task.setTaskStatus(taskStatus);
		taskmanagerservice.addTask(task);
		return taskmanagerservice.getAllTasks();

	}*/
}