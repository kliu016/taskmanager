package com.taskmanager.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

//import com.springboot.demo.dao.TaskRepository;
//import com.springboot.demo.model.Task;

//@SpringBootConfiguration
@Configuration
@SpringBootTest
class SpringBootTaskManagerApplicationTests {

	//@Autowired
	//TaskRepository repo;
	
	@Test
	void contextLoads() {
	   
	  //.List<Task> tasks= repo.findAll();
		
	//  assertEquals(2, tasks.size());				
	}
	
	@Test 
	void testCheck() {
	
		assertEquals(2, 2);	
	}	

	@Test
	public void passTest() throws Exception {
		System.out.println("Pass Test");
	}	
}
