package com.youssefi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.youssefi.entities.*;
import com.youssefi.repositories.TaskRepository;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TestController {
	
	@Autowired
	TaskRepository taskRepository;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/tasks")
	public List<Task> listTasks() {
		
		return taskRepository.findAll();
	}

	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PostMapping("/tasks")
	public Task save(@RequestBody Task t) {
		
		return taskRepository.save(t);
	}
	
	
}
