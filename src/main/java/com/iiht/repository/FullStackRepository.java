package com.iiht.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iiht.dto.ParentTask;
import com.iiht.dto.Project;
import com.iiht.dto.Task;
import com.iiht.dto.User;

@Repository
@Transactional
public class FullStackRepository implements IFullStackRepository{
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public User addUser(User user) {
		Query query = entityManager.createNativeQuery("insert into IIHT.TUSERS(FIRST_NAME,LAST_NAME,EMPLOYEE_ID,PROJECT_ID,TASK_ID) values(:firstName,:lastName,:employeeId,null,null)");
		query.setParameter("firstName",user.getFirstName());
		query.setParameter("lastName",user.getLastName());
		query.setParameter("employeeId", user.getEmployeeId());
		query.executeUpdate();
		user.setStatus("User added Successfully!!");
		
		return user;
	}

	@Override
	public List<User> viewUsers() {
		Query query = entityManager.createNativeQuery("select USER.FIRST_NAME,USER.LAST_NAME,USER.EMPLOYEE_ID from IIHT.TUSERS USER");
		 List<User> users = convertToListofObjects(query.getResultList());
		 return users;
	}

	@Override
	public User updateUser(User user) {
		Query query = entityManager.createNativeQuery("update IIHT.TUSERS USER SET USER.FIRST_NAME= 'Koti',USER.LAST_NAME= 'Kaku' where USER.EMPLOYEE_ID= 102");
		/*
		 * query.setParameter("firstName",user.getFirstName());
		 * query.setParameter("lastName",user.getLastName());
		 * query.setParameter("employeeId", user.getEmployeeId());
		 */
		query.executeUpdate();
		user.setStatus("Success");			
		return user;
	}

	@Override
	public List<User> searchUser(int employeeId) {
		Query query = entityManager.createNativeQuery("select USER.FIRST_NAME,USER.LAST_NAME,USER.EMPLOYEE_ID from IIHT.TUSERS USER where USER.EMPLOYEE_ID= :employeeId");
		 query.setParameter("employeeId",employeeId);
		 List<User> users = convertToListofObjects(query.getResultList());
		 return users;
	}
	
	private List<User> convertToListofObjects(List<Object[]> objArray){
		
		List<User> users = new ArrayList<>();
		for(Object[] obj:objArray) {
			User user = new User();
			user.setFirstName(obj[0].toString());
			user.setLastName(obj[1].toString());
			user.setEmployeeId(Integer.parseInt(obj[2].toString()));
			users.add(user);
		}
		return users;
	}

	@Override
	public List<User> sortUser() {
		Query query = entityManager.createNativeQuery("select USER.FIRST_NAME,USER.LAST_NAME,USER.EMPLOYEE_ID from IIHT.TUSERS USER order by EMPLOYEE_ID");
		 List<User> users = convertToListofObjects(query.getResultList());
		 return users;
	}
	
	@Override
	public List<User> sortUserByFirstNm() {
		Query query = entityManager.createNativeQuery("select USER.FIRST_NAME,USER.LAST_NAME,USER.EMPLOYEE_ID from IIHT.TUSERS USER order by FIRST_NAME");
		 List<User> users = convertToListofObjects(query.getResultList());
		 return users;
	}

	
	@Override
	public List<User> sortUserByLastNm() {
		Query query = entityManager.createNativeQuery("select USER.FIRST_NAME,USER.LAST_NAME,USER.EMPLOYEE_ID from IIHT.TUSERS USER order by LAST_NAME");
		 List<User> users = convertToListofObjects(query.getResultList());
		 return users;
	}

	@Override
	public Project addProject(Project project) {
		Query query = entityManager.createNativeQuery("insert into IIHT.TPROJECT(PROJECT,START_DT,END_DT,PRORITY) values(:projectNm,:startDt,:endDt,:priority)");
		query.setParameter("projectNm",project.getProjectNm());
		try {
			query.setParameter("startDt",StringToSqlDate(project.getStartDt()));
			query.setParameter("endDt", StringToSqlDate(project.getEndDt()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		query.setParameter("priority", project.getPriority());
		query.executeUpdate();
		project.setStatus("Project added Successfully!!");
		
		return project;
	}
	
	
	private java.sql.Date StringToSqlDate(String date) throws ParseException {
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 java.util.Date date1 = formatter.parse(date);
		 java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
		 return sqlDate;
	}
	
	private static java.sql.Date Date(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

	@Override
	public List<ParentTask> searchParentTasks() {
		Query query = entityManager.createNativeQuery("select Distinct PT.PARENT_ID,PT.PARENT_TASK from IIHT.TPARENTTASK PT");
		return query.getResultList();
	}

	@Override
	public List<Project> searchProject() {
		Query query = entityManager.createNativeQuery("select Distinct PR.PROJECT_ID,PR.PROJECT,PR.START_DT,PR.END_DT,PR.PRORITY from IIHT.TPROJECT PR");
		return query.getResultList();
	}

	@Override
	public Task addTask(Task task) {
		Query query = entityManager.createNativeQuery("insert into IIHT.TTASK(PARENT_ID,PROJECT_ID,TASK,START_DT,END_DT,PRORITY,STATUS) values(:parentId,:projectId,:task,:startDt,:endDt,:priority,:status)");
		query.setParameter("parentId",task.getParentTaskId());
		query.setParameter("projectId",task.getProjectId());
		query.setParameter("task", task.getTaskNm());
		try {
			query.setParameter("startDt",StringToSqlDate(task.getStartDt()));
			query.setParameter("endDt", StringToSqlDate(task.getEndDt()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		query.setParameter("priority", task.getPriority());
		query.setParameter("status",task.getStatus());
		query.executeUpdate();
		task.setSaveStatus("Task added Succesfully!!");
		return task;
	}

	@Override
	public List<Task> viewTasks() {
		Query query = entityManager.createNativeQuery("select TA.TASK_ID,TA.PARENT_ID,TA.PROJECT_ID,TA.TASK,TA.START_DT,TA.END_DT,TA.STATUS,TA.PRORITY from IIHT.TTASK TA");
		 List<Task> tasks = new ArrayList<>();
		try {
			tasks = convertToListofTaskObjects(query.getResultList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return tasks;
	}

	private List<Task> convertToListofTaskObjects(List<Object[]> objArray) throws ParseException {
		List<Task> tasks = new ArrayList<>();
		for(Object[] obj:objArray) {
			Task task = new Task();
			task.setTaskId(Integer.parseInt(obj[0].toString()));
			task.setParentTaskId(Integer.parseInt(obj[1].toString()));
			task.setProjectId(Integer.parseInt(obj[2].toString()));
			task.setTaskNm(obj[3].toString());
			task.setStartDt(convertStringToDate(obj[4].toString()));
			task.setEndDt(convertStringToDate(obj[5].toString()));
			if(null != obj[7]) {
			task.setPriority(Integer.parseInt(obj[7].toString()));
			}
			if(null != obj[6]) {
			task.setStatus(obj[6].toString());
			}
			tasks.add(task);
	}
		return tasks;
	}
	
	private String convertStringToDate(String dateInString) throws ParseException{
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = formatter.parse(dateInString);
		    return formatter.format(date);
	}

	@Override
	public List<Project> viewProject() {
		Query query = entityManager.createNativeQuery("select TP.PROJECT_ID,TP.PROJECT,TP.START_DT,TP.END_DT,TP.PRORITY from IIHT.TPROJECT TP");
		 List<Project> projects = new ArrayList<>();
		try {
			projects = convertToListofProjectObjects(query.getResultList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return projects;
	}

	private List<Project> convertToListofProjectObjects(List<Object[]> objArray) throws ParseException {
		List<Project> projects = new ArrayList<>();
		for(Object[] obj:objArray) {
			Project project = new Project();
			project.setProjectId(Integer.parseInt(obj[0].toString()));
			project.setProjectNm(obj[1].toString());
			project.setStartDt(convertStringToDate(obj[2].toString()));
			project.setEndDt(convertStringToDate(obj[3].toString()));
			project.setPriority(Integer.parseInt(obj[4].toString()));
			projects.add(project);
	}
		return projects;
	}

	@Override
	public List<Project> sortProjectByStartDt() {
		Query query = entityManager.createNativeQuery("select TP.PROJECT_ID,TP.PROJECT,TP.START_DT,TP.END_DT,TP.PRORITY from IIHT.TPROJECT TP order by TP.START_DT asc");
		 List<Project> projects = new ArrayList<>();
		try {
			projects = convertToListofProjectObjects(query.getResultList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return projects;
	}

	@Override
	public List<Project> sortProjectByEndDt() {
		Query query = entityManager.createNativeQuery("select TP.PROJECT_ID,TP.PROJECT,TP.START_DT,TP.END_DT,TP.PRORITY from IIHT.TPROJECT TP order by TP.END_DT asc");
		 List<Project> projects = new ArrayList<>();
		try {
			projects = convertToListofProjectObjects(query.getResultList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return projects;
	}

	@Override
	public List<Project> sortProjectByPriority() {
		Query query = entityManager.createNativeQuery("select TP.PROJECT_ID,TP.PROJECT,TP.START_DT,TP.END_DT,TP.PRORITY from IIHT.TPROJECT TP order by TP.PRORITY asc");
		 List<Project> projects = new ArrayList<>();
		try {
			projects = convertToListofProjectObjects(query.getResultList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return projects;
	}

	@Override
	public Task endTask(Task task) {
		Query query = entityManager.createNativeQuery("UPDATE IIHT.TTASK TTASK SET TTASK.STATUS =:status WHERE TTASK.TASK_ID=:taskId");
		query.setParameter("status","complete");
		query.setParameter("taskId",task.getTaskId());
		query.executeUpdate();
		task.setSaveStatus("Task updated Succesfully!!");
		return task;
	}

	@Override
	public List<Task> sortTasksByStartDt() {
			Query query = entityManager.createNativeQuery("select TA.TASK_ID,TA.PARENT_ID,TA.PROJECT_ID,TA.TASK,TA.START_DT,TA.END_DT,TA.STATUS,TA.PRORITY from IIHT.TTASK TA order by TA.START_DT asc");
			 List<Task> tasks = new ArrayList<>();
			try {
				tasks = convertToListofTaskObjects(query.getResultList());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return tasks;
	}

	@Override
	public List<Task> sortTasksByEndDt() {
		Query query = entityManager.createNativeQuery("select TA.TASK_ID,TA.PARENT_ID,TA.PROJECT_ID,TA.TASK,TA.START_DT,TA.END_DT,TA.STATUS,TA.PRORITY from IIHT.TTASK TA order by TA.END_DT asc");
		 List<Task> tasks = new ArrayList<>();
		try {
			tasks = convertToListofTaskObjects(query.getResultList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return tasks;
	}

	@Override
	public List<Task> sortTasksByPriority() {
		Query query = entityManager.createNativeQuery("select TA.TASK_ID,TA.PARENT_ID,TA.PROJECT_ID,TA.TASK,TA.START_DT,TA.END_DT,TA.STATUS,TA.PRORITY from IIHT.TTASK TA order by TA.PRORITY asc");
		 List<Task> tasks = new ArrayList<>();
		try {
			tasks = convertToListofTaskObjects(query.getResultList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public List<Task> sortTasksByStatus() {
		Query query = entityManager.createNativeQuery("select TA.TASK_ID,TA.PARENT_ID,TA.PROJECT_ID,TA.TASK,TA.START_DT,TA.END_DT,TA.STATUS,TA.PRORITY from IIHT.TTASK TA where TA.STATUS='complete'");
		 List<Task> tasks = new ArrayList<>();
		try {
			tasks = convertToListofTaskObjects(query.getResultList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}
	
	

}
