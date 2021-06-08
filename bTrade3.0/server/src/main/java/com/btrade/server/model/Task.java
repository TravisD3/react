package com.btrade.server.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "TASK")
public class Task {
	@Id
	@Column(name = "TASK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;

	@Column(name = "TASK_NAME")
	private String taskName;

	@Column(name = "TASK_DESCRIPTION")
	private String taskDesc;

	@Column(name = "TASK_PRIORITY")
	private String taskPriority;

	@Column(name = "TASK_STATUS")
	private String taskStatus;

	@Column(name = "TASK_START_TIME")
	private String taskStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;

	@Column(name = "TASK_END_TIME")
	private String taskEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());;

	public Task() {
	}

	public int getTaskId() {
		return taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskStartTime() {
		return taskStartTime;
	}

	public void setTaskStartTime(String taskStartTime) {
		this.taskStartTime = taskStartTime;
	}

	public String getTaskEndTime() {
		return taskEndTime;
	}

	public void setTaskEndTime(String taskEndTime) {
		this.taskEndTime = taskEndTime;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

}
