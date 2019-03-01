package com.iiht.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.dto.ParentTask;
import com.iiht.dto.Project;
import com.iiht.dto.Task;
import com.iiht.dto.User;
import com.iiht.service.IFullStackService;
@CrossOrigin(origins = "*",allowedHeaders="*")
@RestController
@RequestMapping("/iiht")
public class FullStackController {
	
	@Autowired
	private IFullStackService fullStackService;
	
	@RequestMapping(value="/addUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		user = fullStackService.addUser(user);
		return user;
		
	}
	
	@RequestMapping(value="/addTask",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public Task addTask(@RequestBody Task task) {
		task = fullStackService.addTask(task);
		return task;
		
	}
	
	
	@RequestMapping(value="/viewUser",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> viewUsers() {
		List<User> users = fullStackService.viewUsers();
		return users;
		
	}
	
	@RequestMapping(value="/viewTask",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Task> viewTasks() {
		List<Task> tasks = fullStackService.viewTasks();
		return tasks;
		
	}
	
	@RequestMapping(value="/updateUser",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user) {
		user = fullStackService.updateUser(user);
		return user;
		
	}
	
	@RequestMapping(value="/deleteUser",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public User deleteUser(@RequestParam int employeeId) {
		User user = fullStackService.deleteUser(employeeId);
		return user;
		
	}
	
	@RequestMapping(value="/searchUser",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> searchUser(@RequestParam int employeeId) {
		List<User> users = fullStackService.searchUser(employeeId);
		return users;
	}
		
		@RequestMapping(value="/sortUserByFirstNm",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<User> sortUserByFirstNm() {
			List<User> users = fullStackService.sortUserByFirstNm();
			return users;
		
	}
		
		@RequestMapping(value="/sortUser",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<User> sortUser() {
			List<User> users = fullStackService.sortUser();
			return users;
		
	}
		
		@RequestMapping(value="/sortUserByLastNm",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<User> sortUserByLastNm() {
			List<User> users = fullStackService.sortUserByLastNm();
			return users;
		
	}
		@RequestMapping(value="/addProject",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
		public Project addProject(@RequestBody Project project) {
			project = fullStackService.addProject(project);
			return project;
		}
		
		@RequestMapping(value="/viewProject",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Project> viewProject() {
			List<Project> projects = fullStackService.viewProject();
			return projects;
		}
		
		@RequestMapping(value="/sortProjectByStartDt",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Project> sortProjectByStartDt() {
			List<Project> projects = fullStackService.sortProjectByStartDt();
			return projects;
		}
		
		@RequestMapping(value="/sortProjectbyEndDt",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Project> sortProjectByEndDt() {
			List<Project> projects = fullStackService.sortProjectByEndDt();
			return projects;
		}
		
		@RequestMapping(value="/sortProjectByPriority",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Project> sortProjectByPriority() {
			List<Project> projects = fullStackService.sortProjectByPriority();
			return projects;
		}
		@RequestMapping(value="/searchParentTasks",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<ParentTask> searchParentTasks() {
			List<ParentTask> ptasks = fullStackService.searchParentTasks();
			return ptasks;
		}
		
		@RequestMapping(value="/searchProject",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Project> searchProject() {
			List<Project> projects = fullStackService.searchProject();
			return projects;
		}
		    
		

}
