package com.fortytwoq.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.TestCaseStep;
import com.fortytwoq.mvc.service.impl.TestCaseStepService;

/**
 * TestCaseStep控制器类
 * @author cat
 *
 */
@RestController
@RequestMapping("/testcasestep")
public class TestCaseStepController {

	@Autowired
	private TestCaseStepService testCaseStepService;
	
	/**
	 * 通过id获取testCaseStep资源
	 * @param testCaseStepId
	 * @return
	 */
	@RequestMapping(value = "/{testCaseStepId}", method = RequestMethod.GET)
	public TestCaseStep getTestCaseStepById(@PathVariable("testCaseStepId") Integer testCaseStepId){
		return testCaseStepService.getTestCaseStepByKey(testCaseStepId);
	}

	/**
	 * 获取所有testcasestep资源
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<TestCaseStep> findAllTestCaseStep(){
		return testCaseStepService.findAllTestCaseStep();
	}
	
	/**
	 * 分页获取testcasestep资源
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value = "/{currentPage}/list", method = RequestMethod.GET)
	public PageUtils findTestCaseStepsByPage(@PathVariable("currentPage") Integer currentPage){
		return testCaseStepService.findTestCaseStepsByPage(currentPage);
	}
	
	/**
	 * 添加一个testcasestep
	 * @param testCaseStep
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTestCaseStep(@RequestBody TestCaseStep testCaseStep){
		testCaseStepService.addTestCaseStep(testCaseStep);
		return "redirect:/";
	}
	
	/**
	 * 修改一个testcasestep的数据
	 * @param testCaseStep
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateTestCaseStep(@RequestBody TestCaseStep testCaseStep){
		testCaseStepService.updateTestCaseStep(testCaseStep);
		return "redirect:/";
	}
	
    /**
     * 批量删除TestCaseStep
     * @param testCaseStepIds
     * @return
     */
    @RequestMapping(value = "/deletes", method = RequestMethod.DELETE)
    public String deleteTestCaseStep(@RequestBody List<Integer> testCaseStepIds){
    	testCaseStepService.deleteTestCaseSteps(testCaseStepIds);
    	return "redirect:/";
    }
    
    /**
     * 单个记录删除TestCaseStep
     * @param testCaseStepId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteTestCaseStep(Integer testCaseStepId){
    	testCaseStepService.deleteTestCaseStepByKey(testCaseStepId);
    	return "redirect:/";
    }
	
}
