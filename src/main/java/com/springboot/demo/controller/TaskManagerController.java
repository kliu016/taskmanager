package com.springboot.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.demo.dao.TaskRepository;
import com.springboot.demo.model.Task;

@Controller
public class TaskManagerController {
		
	@Autowired
	TaskRepository repo;
				
	//Retrieve All Task List
	@RequestMapping("/")
	public ModelAndView getAllTasks() 
	{
		ModelAndView mv= new ModelAndView();
		List<Task> tasks= repo.findAll();
		mv.addObject("tasks",tasks);
			
		mv.setViewName("getAllTasks.jsp");
				
		return mv;
	}
	
	@RequestMapping(value="/Search", method = RequestMethod.POST)
	public ModelAndView doSearch(@RequestParam("keyword") String keyword) 
	{	
		//. Get exist list first
		List<Task> tasks = null;		
		if (keyword!=null && keyword.length()>0)
		{//. If enter search keyword, do search
			tasks = repo.findByKeword(keyword);
		}
		else
			tasks = repo.findAll();
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("tasks", tasks);  
				
		mv.setViewName("getAllTasks.jsp");
				
		return mv;
	}

	@GetMapping(value = "/Delete/{id}")
	public ModelAndView doDelete(@PathVariable("id") int id) 
	{				
		//. Delete it first
		repo.deleteById(id);
		
		ModelAndView mv= new ModelAndView();
		List<Task> tasks= repo.findAll();
System.out.println("Curent size=" + tasks.size());
		mv.addObject("tasks",tasks);
			
		mv.setViewName("getAllTasks.jsp");
		
System.out.println("Before return ");

		return mv;
	}
	
	@RequestMapping("/Update")
	public ModelAndView doUpdate(@RequestParam Map<String,String> requestParams) 
	{			
		//. Get exist list first
		List<Task> tasks = repo.findAll();
	
		for (Task task : tasks)
		{
		   //. Check status
           String selectName = "sts_" + task.getId();	
           String selectValue = requestParams.get(selectName);	
           if (selectValue!=null && !selectValue.equalsIgnoreCase(task.getCompletestatus()))
           {
        	  task.setCompletestatus(selectValue);
        	  repo.save(task);
           }
		}
				
		ModelAndView mv= new ModelAndView();
		mv.addObject("tasks",tasks);
		
		mv.setViewName("getAllTasks.jsp");
				
		return mv;
	}
		
}
