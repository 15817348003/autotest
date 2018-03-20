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
import com.fortytwoq.mvc.model.TestModule;
import com.fortytwoq.mvc.service.impl.ProjectService;
import com.fortytwoq.mvc.test.BaseJunit4Test;
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
			projectService.add(project);
		}
	}
	
	@Test
	@Ignore
	public void updateProjectTest(){
		Project project = new Project();
		project.setId(3);
		project.setProjectName("project already upadte");
		boolean result = projectService.update(project);
		assertTrue(result);
	}
	
	@Test
	public void getProjectByKeyTest(){
		System.out.println("getProjectByKey : " + projectService.getByKey(3).toString());
	}
	
	@Test
	public void deleteProjectByKeyTest(){
		assertTrue(projectService.deleteByKey(80));
	}
	
	@Test
	@Ignore
	public void deleteProjectsTest(){
		List<Integer> list = Arrays.asList(95,96,97,98,99,100);
		assertTrue(projectService.deleteByIds(list));
	}
	
	@Test
	public void findAllProjectTest(){
		List<Project> list = projectService.findAll();
		System.out.println("findAllProjectTest");
		for(Project project : list){
			System.out.println(project.toString());
		}
	}
	
	@Test
	public void findProjectsByPageTest(){
		PageUtils page = projectService.findByPage(2);
		System.out.println("findProjectsByPageTest");
		System.out.println(page);
		
		@SuppressWarnings("unchecked")
		List<Project> list =(List<Project>) page.getList();
		for(Project project : list){
			System.out.println(project.toString());
		}
	}
	
	@Test
	public void testQueryTest(){
		Project project = projectService.testQuery();
		for(TestModule module : project.getTestModules()){
			System.out.println(module.toString());
		}
		System.out.println(project);
	}
}
