package com.seventec.TodoApp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seventec.TodoApp.dto.TaskDto;
import com.seventec.TodoApp.service.TaskService;

@RestController
@RequestMapping(value = "/tarefas")
public class TaskController {

	private TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping
	public ResponseEntity<List<TaskDto>> index() {
		return this.taskService.index();
	}
	
	@PostMapping
	public ResponseEntity<TaskDto> store(@RequestBody TaskDto taskDto) {
		return this.taskService.store(taskDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TaskDto> update(@RequestBody TaskDto taskDto, @PathVariable Long id) {
		return this.taskService.edit(taskDto, id);
	}
}
