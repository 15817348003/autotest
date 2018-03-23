package com.fortytwoq.mvc.test.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.TestCaseStep;
import com.fortytwoq.mvc.service.impl.TestCaseStepService;
import com.fortytwoq.mvc.test.BaseJunit4Test;

//@Ignore
public class TestCaseStepServiceTest extends BaseJunit4Test {

	@Autowired
	private TestCaseStepService testCaseStepService;
	
	@Test
	@Ignore
	public void addTestCaseStepTest(){
		for(int i=0; i< 101; i++){
			TestCaseStep testCaseStep = new TestCaseStep();
			testCaseStep.setTestCaseId(55);
			testCaseStep.setSubStep(2);
			testCaseStep.setStepType(3);
			testCaseStep.setStepId("stepId" + i);
			testCaseStep.setSeq("seq" + i);
			testCaseStep.setWaitElementLocated("waitElementLocated" + i);
			testCaseStep.setElementXpth("elementXpth" + i);
			testCaseStep.setElementAction("elementAction" + i);
			testCaseStep.setClean("clean" + i);
			testCaseStep.setElementValue("elementValue" + i);
			testCaseStep.setPauseSec(new Date());
			testCaseStep.setCreateDate(new Date());
			testCaseStep.setUpdateDate(new Date());
			testCaseStepService.add(testCaseStep);
		}
	}
	
	@Test
	public void updateTestCaseStepTest(){
		TestCaseStep testCaseStep = new TestCaseStep();
		testCaseStep.setId(3);
		testCaseStep.setStepId("stepId already upadte");
		boolean result = testCaseStepService.update(testCaseStep);
		assertTrue(result);
	}
	
	@Test
	public void getTestCaseStepByKeyTest(){
		System.out.println("getTestCaseStepByKey : " + testCaseStepService.getByKey(3).toString());
	}
	
	@Test
	public void deleteTestCaseStepByKeyTest(){
		assertTrue(testCaseStepService.deleteByKey(100));
	}
	
	@Test
	public void deleteTestCaseStepsTest(){
		List<Integer> list = Arrays.asList(95,96,97,98,99);
		assertTrue(testCaseStepService.deleteByIds(list));
	}
	
	@Test
	public void findAllTestCaseStepTest(){
		List<TestCaseStep> list = testCaseStepService.findAll();
		System.out.println("findAllTestCaseStepTest");
		for(TestCaseStep testCaseStep : list){
			System.out.println(testCaseStep.toString());
		}
	}
	
	@Test
	public void findTestCaseStepsByPageTest(){
		PageUtils page = testCaseStepService.findByPage(5);
		System.out.println("findTestCaseStepsByPageTest");
		System.out.println(page);
		
		@SuppressWarnings("unchecked")
		List<TestCaseStep> list =(List<TestCaseStep>) page.getList();
		for(TestCaseStep testCaseStep : list){
			System.out.println(testCaseStep.toString());
		}
	}
}
