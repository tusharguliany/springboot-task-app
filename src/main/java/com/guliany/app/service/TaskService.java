package com.guliany.app.service;

import com.guliany.app.entity.Task;
import com.guliany.app.exception.service.ServiceException;

public interface TaskService {

	public Object getAllTasks();
	public Object getTaskById(Long id) throws ServiceException;
	public Object createTask(Task task);
	public Object updateTask(Long id, Task task) throws ServiceException;
	public Object deleteTaskById(Long id);
	public Object deleteAllTasks();
	
}
