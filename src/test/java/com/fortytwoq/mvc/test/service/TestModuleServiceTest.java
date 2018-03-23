package com.fortytwoq.mvc.test.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.TestModule;
import com.fortytwoq.mvc.service.impl.TestModuleService;
import com.fortytwoq.mvc.test.BaseJunit4Test;

//@Ignore
public class TestModuleServiceTest extends BaseJunit4Test {

	@Autowired
	private TestModuleService testModuleService;
	
	@Test
	@Ignore
	public void addTestModuleTest(){
		for(int i=0; i< 101; i++){
			TestModule testModule = new TestModule();
			testModule.setModuleName("moduleName" + i);
			testModule.setParentModuleId(i % 5);
			testModule.setProjectId(30);
			testModule.setType("type" + i);
			testModule.setSequence("sequence" + i);
			testModule.setLevel(i % 5);
			testModule.setEnable(1);
			testModule.setCreateDate(new Date());
			testModule.setUpdateDate(new Date());
			testModuleService.add(testModule);
		}
	}
	
	@Test
	public void updateTestModuleTest(){
		TestModule testModule = new TestModule();
		testModule.setId(30);
		testModule.setModuleName("testModule already upadte");
		boolean result = testModuleService.update(testModule);
		assertTrue(result);
	}
	
	@Test
	public void getTestModuleByKeyTest(){
		System.out.println("getTestModuleByKey : " + testModuleService.getByKey(80).toString());
	}
	
	@Test
	public void deleteTestModuleByKeyTest(){
		assertTrue(testModuleService.deleteByKey(100));
	}
	
	@Test
	public void deleteTestModulesTest(){
		List<Integer> list = Arrays.asList(95,96,97,98,99);
		assertTrue(testModuleService.deleteByIds(list));
	}
	
	@Test
	public void findAllTestModuleTest(){
		List<TestModule> list = testModuleService.findAll();
		System.out.println("findAllTestModuleTest");
		for(TestModule testModule : list){
			System.out.println(testModule.toString());
		}
	}
	
	@Test
	public void findTestModulesByPageTest(){
		PageUtils page = testModuleService.findByPage(5);
		System.out.println("findTestModulesByPageTest");
		System.out.println(page);
		
		@SuppressWarnings("unchecked")
		List<TestModule> list =(List<TestModule>) page.getList();
		for(TestModule testModule : list){
			System.out.println(testModule.toString());
		}
	}
}
