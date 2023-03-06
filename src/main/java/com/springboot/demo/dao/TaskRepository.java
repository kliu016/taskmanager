package com.springboot.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.demo.model.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
		
	@Query("SELECT u FROM Task u WHERE u.id = :id")
	Task getTaskById(@Param("id") String id);

	@Query("SELECT m FROM Task m WHERE m.description LIKE %:keyword%")
	List<Task> findByKeword(String keyword);
	
}
