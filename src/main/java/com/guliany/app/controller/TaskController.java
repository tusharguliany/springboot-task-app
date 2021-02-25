package com.guliany.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guliany.app.entity.Task;
import com.guliany.app.exception.AppException;
import com.guliany.app.service.TaskService;
import com.guliany.app.util.CommonUtil;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/v1/task")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	public TaskController() {
	}
	
	@GetMapping
	public ResponseEntity<?> getControllerInfo() {
		log.trace("getControllerInfo called in TaskController");
		return new ResponseEntity<>(CommonUtil.getResponse("message", "Welcome to Task Controller"), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllTasks() {
		log.trace("getAllTasks called in TaskController");
		return new ResponseEntity<>(this.taskService.getAllTasks(), HttpStatus.OK);
	}
	
	@GetMapping("/{taskId}")
	public ResponseEntity<?> getTaskById(@PathVariable(name = "taskId") Long id) throws AppException {
		log.trace("getTaskById called in TaskController");
		return new ResponseEntity<>(this.taskService.getTaskById(id), HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> createTask(@Valid @RequestBody Task task) {
		log.trace("createTask called in TaskController");
		return new ResponseEntity<>(this.taskService.createTask(task), HttpStatus.CREATED);
	}
	
	@PutMapping("/{taskId}")
	public ResponseEntity<?> updateTask(@PathVariable(name = "taskId") Long id, @Valid @RequestBody Task task) throws AppException {
		log.trace("updateTask called in TaskController");
		return new ResponseEntity<>(this.taskService.updateTask(id, task), HttpStatus.OK);
	}
	
	@DeleteMapping("/{taskId}")
	public ResponseEntity<?> deleteTask(@PathVariable(name = "taskId") Long id) {
		log.trace("deleteTask called in TaskController");
		return new ResponseEntity<>(this.taskService.deleteTaskById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-all")
	public ResponseEntity<?> deleteAllTasks() {
		log.trace("deleteAllTasks called in TaskController");
		return new ResponseEntity<>(this.taskService.deleteAllTasks(), HttpStatus.OK);
	}

}
