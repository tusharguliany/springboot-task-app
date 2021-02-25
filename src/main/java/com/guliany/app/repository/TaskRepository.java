package com.guliany.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guliany.app.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
