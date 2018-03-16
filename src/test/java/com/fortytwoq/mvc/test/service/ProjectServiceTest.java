package com.fortytwoq.mvc.test.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.Project;
import com.fortytwoq.mvc.service.impl.ProjectService;
import com.fortytwoq.mvc.test.BaseJunit4Test;
@Ignore
public class ProjectServiceTest extends BaseJunit4Test {

	@Autowired
	private ProjectService projectService;
	
	@Test
	@Ignore
	public void addProjectTest(){
		for(int i=0; i< 50; i++){
			Project project = new Project();
			//project.setId(1);
			project.setProjectName("project" + i);
			project.setProjectCode("projectcode" + i);
			project.setEnable(1);
			project.setCreateDate(new Date());
			project.setUpdateDate(new Date());
			projectService.addProject(project);
		}
	}
	
	@Test
	@Ignore
	public void updateProjectTest(){
		Project project = new Project();
		project.setId(3);
		project.setProjectName("project already upadte");
		boolean result = projectService.updateProject(project);
		assertTrue(result);
	}
	
	@Test
	public void getProjectByKeyTest(){
		System.out.println("getProjectByKey : " + projectService.getProjectByKey(3).toString());
	}
	
	@Test
	public void deleteProjectByKeyTest(){
		assertTrue(projectService.deleteProjectByKey(80));
	}
	
	@Test
	@Ignore
	public void deleteProjectsTest(){
		List<Integer> list = Arrays.asList(95,96,97,98,99,100);
		assertTrue(projectService.deleteProjects(list));
	}
	
	@Test
	public void findAllProjectTest(){
		List<Project> list = projectService.findAllProject();
		System.out.println("findAllProjectTest");
		for(Project project : list){
			System.out.println(project.toString());
		}
	}
	
	@Test
	public void findProjectsByPageTest(){
		PageUtils page = projectService.findProjectsByPage(5);
		System.out.println("findProjectsByPageTest");
		System.out.println(page);
		
		@SuppressWarnings("unchecked")
		List<Project> list =(List<Project>) page.getList();
		for(Project project : list){
			System.out.println(project.toString());
		}
	}
}
