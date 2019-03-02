package com.iiht.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.dto.ParentTask;
import com.iiht.dto.Project;
import com.iiht.dto.Task;
import com.iiht.dto.User;
import com.iiht.repository.FullStackDeleteRepository;
import com.iiht.repository.FullStackUpdateRepository;
import com.iiht.repository.IFullStackRepository;

@Component
public class FullStackDomain implements IFullStackDomain {
	
	@Autowired
	private IFullStackRepository fullStackRepository;

	@Override
	public User addUser(User user) {
		user =fullStackRepository.addUser(user);
		return user;
	}

	@Override
	public List<User> viewUsers() {
		List<User> users = fullStackRepository.viewUsers();
		return users;
	}

	@Override
	public User updateUser(User user) {
		FullStackUpdateRepository.updateUser(user);
		//user =fullStackRepository.updateUser(user);
		return user;
	}
	
	@Override
	public User deleteUser(int employeeId) {
		User user = new User();
		FullStackDeleteRepository.deleteUser(employeeId);
		user.setStatus("User deleted Successfully!!");
		return user;
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> searchUser(int employeeId) {
		List<User> users = fullStackRepository.searchUser(employeeId);
		return users;
	}

	@Override
	public List<User> sortUser() {
		List<User> users = fullStackRepository.sortUser();
		return users;
	}
	
	public List<User> sortUserByFirstNm() {
		List<User> users = fullStackRepository.sortUserByFirstNm();
		return users;
	
}
	
	public List<User> sortUserByLastNm() {
		List<User> users = fullStackRepository.sortUserByLastNm();
		return users;
	
}

	@Override
	public Project addProject(Project project) {
		project =fullStackRepository.addProject(project);
		return project;
	}

	@Override
	public List<ParentTask> searchParentTasks() {
		List<ParentTask> ptasks = fullStackRepository.searchParentTasks();
		return ptasks;
	}

	@Override
	public List<Project> searchProject() {
		List<Project> projects = fullStackRepository.searchProject();
		return projects;
	}

	@Override
	public Task addTask(Task task) {
		task = fullStackRepository.addTask(task);
		return task;
	}

	@Override
	public List<Task> viewTasks() {
		List<Task> tasks = fullStackRepository.viewTasks();
		return tasks;
	}

	@Override
	public List<Project> viewProject() {
		List<Project> projects = fullStackRepository.viewProject();
		return projects;
	}

	@Override
	public List<Project> sortProjectByStartDt() {
		List<Project> projects = fullStackRepository.sortProjectByStartDt();
		return projects;
	}

	@Override
	public List<Project> sortProjectByEndDt() {
		List<Project> projects = fullStackRepository.sortProjectByEndDt();
		return projects;
	}

	@Override
	public List<Project> sortProjectByPriority() {
		List<Project> projects = fullStackRepository.sortProjectByPriority();
		return projects;
	}

	@Override
	public Task endTask(Task task) {
		task = fullStackRepository.endTask(task);
		return task;
	}

	@Override
	public List<Task> sortTasksByStartDt() {
		List<Task> tasks = fullStackRepository.sortTasksByStartDt();
		return tasks;
	}

	@Override
	public List<Task> sortTasksByEndDt() {
		List<Task> tasks = fullStackRepository.sortTasksByEndDt();
		return tasks;
	}

	
	@Override
	public List<Task> sortTasksByPriority() {
		List<Task> tasks = fullStackRepository.sortTasksByPriority();
		return tasks;
	}
	
	@Override
	public List<Task> sortTasksByStatus() {
		List<Task> tasks = fullStackRepository.sortTasksByStatus();
		return tasks;
	}


}
