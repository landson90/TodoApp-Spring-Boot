package com.seventec.TodoApp.dto;

import com.seventec.TodoApp.models.TaskEntity;

public class TaskDto {
	
	private Long id;
	private String title;
	private Boolean status;
	
	public TaskDto() { }

	public TaskDto(TaskEntity taskEntity) {
		this.id 	= taskEntity.getId();
		this.title 	= taskEntity.getTitle();
		this.status = taskEntity.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	

}
