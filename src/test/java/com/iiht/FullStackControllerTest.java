package com.iiht;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iiht.dto.Project;
import com.iiht.dto.Task;
import com.iiht.dto.User;
import com.iiht.service.FullStackService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FullStackControllerTest {
	@Autowired
	FullStackService fullStackService;
	
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
		fullStackService.addUser(user);
		//Assert.assertEquals("User added Succesfully!!", user.getStatus());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewUsers() {
		fullStackService.viewUsers();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateUser() {
		User user = new User();
		user.setFirstName("JackyX");
		user.setLastName("chanY");
		user.setEmployeeId(101);
		fullStackService.addUser(user);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchUser() {
		fullStackService.searchUser(101);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUser() {
		fullStackService.sortUser();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUserByFirstNm() {
		fullStackService.sortUserByFirstNm();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUserByLastNm() {
		fullStackService.sortUserByLastNm();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchParentTasks() {
		fullStackService.searchParentTasks();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchProject() {
		fullStackService.searchProject();
	}



	@Test
	@Transactional
	@Rollback(true)
	public void testViewTasks() {
		fullStackService.viewTasks();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewProject() {
		fullStackService.viewProject();
	}
	

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByStartDt() {
		fullStackService.sortProjectByStartDt();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByEndDt() {
		fullStackService.sortProjectByEndDt();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByPriority() {
		fullStackService.sortProjectByPriority();
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
		fullStackService.addProject(project);
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
		fullStackService.addTask(task);
	}
	
	
	private Date convertDateToString(String date) throws ParseException {	
	    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);  
	    return date1;
	}



}
