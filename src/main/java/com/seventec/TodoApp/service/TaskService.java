package com.seventec.TodoApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.seventec.TodoApp.dto.TaskDto;
import com.seventec.TodoApp.models.TaskEntity;
import com.seventec.TodoApp.repository.TaskRepository;

import java.net.URI;

@Service
public class TaskService {
	
	private TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	public ResponseEntity<List<TaskDto>> index() {
		List<TaskEntity> tasksEntity = this.taskRepository.findAll();
		List<TaskDto> tasksDto = tasksEntity.stream().map(t -> new TaskDto(t)).collect(Collectors.toList());
		return ResponseEntity.ok().body(tasksDto);
	}

	public ResponseEntity<TaskDto> store(TaskDto taskDto) {
		TaskEntity taskEntity = this.taskRepository.save(this.convertTaskDtoInTaskEntity(taskDto));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(taskEntity.getId()).toUri();
		return ResponseEntity.created(uri).body(new TaskDto(taskEntity));
	}

	private TaskEntity convertTaskDtoInTaskEntity(TaskDto taskDto) {
		return new TaskEntity(taskDto.getId(), taskDto.getTitle(), taskDto.getStatus());
	}

}
