package com.fortytwoq.mvc.service;

import java.util.List;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.TestCase;

/**
 * TestCase业务接口
 * @author cat
 *
 */
public interface ITestCaseService {
	public TestCase getTestCaseByKey(Integer testCaseId);
	
	public List<TestCase> findAllTestCase();
	
	public PageUtils findTestCasesByPage(int currentPage);
	
	public boolean addTestCase(TestCase testCase);
	
	public boolean updateTestCase(TestCase testCase);
	
	public boolean deleteTestCaseByKey(int testCaseId);
	
	public boolean deleteTestCases(List<Integer> tstModuleIds);
}
