package com.iiht.domain;

import java.util.List;

import com.iiht.dto.ParentTask;
import com.iiht.dto.Project;
import com.iiht.dto.Task;
import com.iiht.dto.User;

public interface IFullStackDomain {

	User addUser(User user);

	List<User> viewUsers();

	User updateUser(User user);

	List<User> searchUser(int employeeId);

	List<User> sortUser();

	User deleteUser(int employeeId);

	List<User> sortUserByLastNm();

	List<User> sortUserByFirstNm();

	Project addProject(Project project);

	List<ParentTask> searchParentTasks();

	List<Project> searchProject();

	Task addTask(Task task);

	List<Task> viewTasks();

	List<Project> viewProject();

	List<Project> sortProjectByStartDt();

	List<Project> sortProjectByEndDt();

	List<Project> sortProjectByPriority();

	Task endTask(Task task);

	List<Task> sortTasksByStartDt();

	List<Task> sortTasksByEndDt();

	List<Task> sortTasksByStatus();
	
	List<Task> sortTasksByPriority();


}
