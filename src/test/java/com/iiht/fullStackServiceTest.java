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

import com.iiht.domain.FullStackDomain;
import com.iiht.dto.Project;
import com.iiht.dto.Task;
import com.iiht.dto.User;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class fullStackServiceTest {

	@Autowired
	FullStackDomain fullStackDomain;
	
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
		fullStackDomain.addUser(user);
		//Assert.assertEquals("User added Succesfully!!", user.getStatus());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewUsers() {
		fullStackDomain.viewUsers();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateUser() {
		User user = new User();
		user.setFirstName("JackyX");
		user.setLastName("chanY");
		user.setEmployeeId(101);
		fullStackDomain.addUser(user);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchUser() {
		fullStackDomain.searchUser(101);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUser() {
		fullStackDomain.sortUser();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUserByFirstNm() {
		fullStackDomain.sortUserByFirstNm();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUserByLastNm() {
		fullStackDomain.sortUserByLastNm();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchParentTasks() {
		fullStackDomain.searchParentTasks();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchProject() {
		fullStackDomain.searchProject();
	}



	@Test
	@Transactional
	@Rollback(true)
	public void testViewTasks() {
		fullStackDomain.viewTasks();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewProject() {
		fullStackDomain.viewProject();
	}
	

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByStartDt() {
		fullStackDomain.sortProjectByStartDt();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByEndDt() {
		fullStackDomain.sortProjectByEndDt();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByPriority() {
		fullStackDomain.sortProjectByPriority();
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
		fullStackDomain.addProject(project);
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
		fullStackDomain.addTask(task);
	}
	
	
	private Date convertDateToString(String date) throws ParseException {	
	    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);  
	    return date1;
	}


}
