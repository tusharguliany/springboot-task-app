package com.guliany.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guliany.app.dto.ResponseDTO;
import com.guliany.app.entity.Task;
import com.guliany.app.exception.service.EntityNotFoundException;
import com.guliany.app.exception.service.ServiceException;
import com.guliany.app.repository.TaskRepository;
import com.guliany.app.service.TaskService;
import com.guliany.app.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public TaskServiceImpl() {
	}

	@Override
	public ResponseDTO getAllTasks() {
		log.trace("getAllTasks called in TaskServiceImpl");
		return CommonUtil.getResponse("tasks", this.taskRepository.findAll());
	}

	@Override
	public ResponseDTO getTaskById(Long id) throws ServiceException {
		log.trace("getTaskById called in TaskServiceImpl");
		Task task = this.taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found."));
		return CommonUtil.getResponse("task", task);
	}

	@Override
	public ResponseDTO createTask(Task task) {
		log.trace("createTask called in TaskServiceImpl");
		return CommonUtil.getResponse("task", this.taskRepository.save(task));
	}

	@Override
	public ResponseDTO updateTask(Long id, Task task) throws ServiceException {
		log.trace("updateTask called in TaskServiceImpl");
		Task taskInDB = this.taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Task not found."));
		taskInDB.setName(task.getName());
		taskInDB.setDescription(task.getDescription());
		return CommonUtil.getResponse("task", this.taskRepository.save(taskInDB));
	}

	@Override
	public ResponseDTO deleteTaskById(Long id) {
		log.trace("deleteTaskById called in TaskServiceImpl");
		this.taskRepository.deleteById(id);
		return CommonUtil.getResponse("status", "Done..");
	}

	@Override
	public ResponseDTO deleteAllTasks() {
		log.trace("deleteAllTasks called in TaskServiceImpl");
		this.taskRepository.deleteAll();
		return CommonUtil.getResponse("status", "Done..");
	}

}
