package com.seventec.TodoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seventec.TodoApp.models.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>{

}
