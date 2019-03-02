package com.iiht;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iiht.controller.FullStackController;
import com.iiht.dto.Project;
import com.iiht.dto.Task;
import com.iiht.dto.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	FullStackController fullStackController;

	
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAddUser() {
		User user = new User();
		user.setFirstName("Jacky");
		user.setLastName("chan");
		user.setEmployeeId(101);
		fullStackController.addUser(user);
		//Assert.assertEquals("User added Succesfully!!", user.getStatus());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewUsers() {
		fullStackController.viewUsers();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateUser() {
		User user = new User();
		user.setFirstName("JackyX");
		user.setLastName("chanY");
		user.setEmployeeId(101);
		fullStackController.addUser(user);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchUser() {
		fullStackController.searchUser(101);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUser() {
		fullStackController.sortUser();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUserByFirstNm() {
		fullStackController.sortUserByFirstNm();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUserByLastNm() {
		fullStackController.sortUserByLastNm();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchParentTasks() {
		fullStackController.searchParentTasks();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchProject() {
		fullStackController.searchProject();
	}



	@Test
	@Transactional
	@Rollback(true)
	public void testViewTasks() {
		fullStackController.viewTasks();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewProject() {
		fullStackController.viewProject();
	}
	

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByStartDt() {
		fullStackController.sortProjectByStartDt();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByEndDt() {
		fullStackController.sortProjectByEndDt();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByPriority() {
		fullStackController.sortProjectByPriority();
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAddProject() throws ParseException {
		Project project = new Project();
		project.setProjectNm("Project1");
		project.setPriority(5);
		project.setStartDt("2019-10-10");
		project.setEndDt("2019-12-10");
		fullStackController.addProject(project);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAddTask() throws ParseException {
		Task task = new Task();
		task.setParentTaskId(5);
		task.setProjectId(4);
		task.setTaskNm("Project1");
		task.setPriority(5);
		task.setStartDt("2019-10-10");
		task.setEndDt("2019-12-10");
		fullStackController.addTask(task);
	}
	
	
	private Date convertDateToString(String date) throws ParseException {	
	    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);  
	    return date1;
	}


}

