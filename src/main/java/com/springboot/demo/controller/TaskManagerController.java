package com.springboot.demo.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.demo.dao.TaskRepository;
import com.springboot.demo.model.Task;

@Controller
public class TaskManagerController {
		
	@Autowired
	TaskRepository repo;
		
		
	//Retrieve All Task List
	@RequestMapping("/")
	public ModelAndView getAllTasks(HttpServletRequest req, HttpServletResponse res) 
	{
		ModelAndView mv= new ModelAndView();
		List<Task> tasks= repo.findAll();
		mv.addObject("tasks",tasks);
		
		req.setAttribute("TASK_LIST", tasks);
		
		mv.setViewName("getAllTasks.jsp");
				
		return mv;
	}
	
	@RequestMapping("/Update")
	public ModelAndView postUpdate(HttpServletRequest req, HttpServletResponse res) 
	{
		//. Get exist list first
		List<Task> tasks = repo.findAll();
		for (Task task : tasks)
		{
			//. Check delete flag
	        String checkName = "del_" + task.getId();
	        if ("1".equalsIgnoreCase(req.getParameter(checkName)))
	        {//. Remove it
	        	repo.deleteById(task.getId());
	        }
	        else
	        {
		       //. Check status
	           String selectName = "sts_" + task.getId();	
	           String selectValue = req.getParameter(selectName);	
	           if (selectValue!=null && !selectValue.equalsIgnoreCase(task.getCompletestatus()))
	           {
	        	  task.setCompletestatus(selectValue);
	        	  repo.save(task);
	           }
	        }	
		}
		
		String keyword = req.getParameter("keyword");
		if (keyword!=null && keyword.length()>0)
		{//. If enter search keyword, do search
			tasks = repo.findByKeword(keyword);
		}
		else
			tasks = repo.findAll();
		
		ModelAndView mv= new ModelAndView();		
		req.setAttribute("TASK_LIST", tasks);
		
		mv.setViewName("getAllTasks.jsp");
				
		return mv;
	}
		
}
