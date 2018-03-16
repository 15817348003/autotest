package com.fortytwoq.mvc.service;

import java.util.List;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.TestCaseStep;

/**
 * TestCaseStep业务接口
 * @author cat
 *
 */
public interface ITestCaseStepService {
	public TestCaseStep getTestCaseStepByKey(Integer testCaseStepId);
	
	public List<TestCaseStep> findAllTestCaseStep();
	
	public PageUtils findTestCaseStepsByPage(int currentPage);
	
	public boolean addTestCaseStep(TestCaseStep testCaseStep);
	
	public boolean updateTestCaseStep(TestCaseStep testCaseStep);
	
	public boolean deleteTestCaseStepByKey(int testCaseStepId);
	
	public boolean deleteTestCaseSteps(List<Integer> tstModuleIds);
}
