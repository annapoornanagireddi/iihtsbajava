package com.iiht.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iiht.domain.IFullStackDomain;
import com.iiht.dto.ParentTask;
import com.iiht.dto.Project;
import com.iiht.dto.Task;
import com.iiht.dto.User;

@Service
public class FullStackService implements IFullStackService{

	@Autowired
	private IFullStackDomain fullStackDomain;
	@Override
	public User addUser(User user) {
		user=fullStackDomain.addUser(user);
		return user;
	}
	@Override
	public List<User> viewUsers() {
		List<User> users = fullStackDomain.viewUsers();
		return users;
	}
	@Override
	public User updateUser(User user) {
		user = fullStackDomain.updateUser(user);
		return user;
	}
	@Override
	public User deleteUser(int employeeId) {
		User user = fullStackDomain.deleteUser(employeeId);
		return user;
	}
	@Override
	public List<User> searchUser(int employeeId) {
		List<User> users = fullStackDomain.searchUser(employeeId);
		return users;
	}
	@Override
	public List<User> sortUser() {
		List<User> users = fullStackDomain.sortUser();
		return users;
	}
	
	@Override
	public List<User> sortUserByFirstNm() {
		List<User> users = fullStackDomain.sortUserByFirstNm();
		return users;
	}

	
	@Override
	public List<User> sortUserByLastNm() {
		List<User> users = fullStackDomain.sortUserByLastNm();
		return users;
	}
	@Override
	public Project addProject(Project project) {
		project = fullStackDomain.addProject(project);
		return project;
	}
	@Override
	public List<ParentTask> searchParentTasks() {
		List<ParentTask> ptasks = fullStackDomain.searchParentTasks();
		return ptasks;
	}
	
	@Override
	public List<Project> searchProject() {
		List<Project> projects = fullStackDomain.searchProject();
		return projects;
	}
	@Override
	public Task addTask(Task task) {
		task = fullStackDomain.addTask(task);
		return task;
	}
	@Override
	public List<Task> viewTasks() {
		List<Task> tasks = fullStackDomain.viewTasks();
		return tasks;
	}
	@Override
	public List<Project> viewProject() {
		List<Project> projects = fullStackDomain.viewProject();
		return projects;
	}
	@Override
	public List<Project> sortProjectByStartDt() {
		List<Project> projects = fullStackDomain.sortProjectByStartDt();
		return projects;
	}
	@Override
	public List<Project> sortProjectByEndDt() {
		List<Project> projects = fullStackDomain.sortProjectByEndDt();
		return projects;
	}
	@Override
	public List<Project> sortProjectByPriority() {
		List<Project> projects = fullStackDomain.sortProjectByPriority();
		return projects;
	}

}
