package com.fortytwoq.mvc.test.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.TestCase;
import com.fortytwoq.mvc.service.impl.TestCaseService;
import com.fortytwoq.mvc.test.BaseJunit4Test;

@Ignore
public class TestCaseServiceTest extends BaseJunit4Test {

	@Autowired
	private TestCaseService testCaseService;
	
	@Test
	public void addTestCaseTest(){
		for(int i=0; i< 101; i++){
			TestCase testCase = new TestCase();
			testCase.setTestCaseId("testCaseId" + i);
			testCase.setCaseName("testCaseName" + i);
			testCase.setTestModuleId(55);
			testCase.setMenuFunctionValue("menuFunctionValue" + i);
			testCase.setMenuModuleValue("menuModuleValue" + i);
			testCase.setClassFunctionName("classFunctionName" + i);
			testCase.setClassModuleName("classModuleName" + i);
			testCase.setEnable(1);
			testCase.setCreateDate(new Date());
			testCase.setUpdateDate(new Date());
			testCaseService.add(testCase);
		}
	}
	
	@Test
	public void updateTestCaseTest(){
		TestCase testCase = new TestCase();
		testCase.setId(3);
		testCase.setCaseName("testCase already upadte");
		boolean result = testCaseService.update(testCase);
		assertTrue(result);
	}
	
	@Test
	public void getTestCaseByKeyTest(){
		System.out.println("getTestCaseByKey : " + testCaseService.getByKey(3).toString());
	}
	
	@Test
	public void deleteTestCaseByKeyTest(){
		assertTrue(testCaseService.deleteByKey(100));
	}
	
	@Test
	public void deleteTestCasesTest(){
		List<Integer> list = Arrays.asList(95,96,97,98,99);
		assertTrue(testCaseService.deleteByIds(list));
	}
	
	@Test
	public void findAllTestCaseTest(){
		List<TestCase> list = testCaseService.findAll();
		System.out.println("findAllTestCaseTest");
		for(TestCase testCase : list){
			System.out.println(testCase.toString());
		}
	}
	
	@Test
	public void findTestCasesByPageTest(){
		PageUtils page = testCaseService.findByPage(5);
		System.out.println("findTestCasesByPageTest");
		System.out.println(page);
		
		@SuppressWarnings("unchecked")
		List<TestCase> list =(List<TestCase>) page.getList();
		for(TestCase testCase : list){
			System.out.println(testCase.toString());
		}
	}
}
