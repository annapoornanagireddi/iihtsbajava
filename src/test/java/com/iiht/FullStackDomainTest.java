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

import com.iiht.dto.Project;
import com.iiht.dto.Task;
import com.iiht.dto.User;
import com.iiht.repository.FullStackRepository;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FullStackDomainTest {

	@Autowired
	FullStackRepository fullStackRepository;
	
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
		fullStackRepository.addUser(user);
		//Assert.assertEquals("User added Succesfully!!", user.getStatus());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewUsers() {
		fullStackRepository.viewUsers();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateUser() {
		User user = new User();
		user.setFirstName("JackyX");
		user.setLastName("chanY");
		user.setEmployeeId(101);
		fullStackRepository.addUser(user);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchUser() {
		fullStackRepository.searchUser(101);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUser() {
		fullStackRepository.sortUser();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUserByFirstNm() {
		fullStackRepository.sortUserByFirstNm();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortUserByLastNm() {
		fullStackRepository.sortUserByLastNm();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchParentTasks() {
		fullStackRepository.searchParentTasks();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSearchProject() {
		fullStackRepository.searchProject();
	}



	@Test
	@Transactional
	@Rollback(true)
	public void testViewTasks() {
		fullStackRepository.viewTasks();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testViewProject() {
		fullStackRepository.viewProject();
	}
	

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByStartDt() {
		fullStackRepository.sortProjectByStartDt();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByEndDt() {
		fullStackRepository.sortProjectByEndDt();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testSortProjectByPriority() {
		fullStackRepository.sortProjectByPriority();
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
		fullStackRepository.addProject(project);
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
		fullStackRepository.addTask(task);
	}
	
	
	private Date convertDateToString(String date) throws ParseException {	
	    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);  
	    return date1;
	}  
	

}
