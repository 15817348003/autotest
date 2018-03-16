package com.fortytwoq.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.TestCase;
import com.fortytwoq.mvc.service.impl.TestCaseService;

/**
 * TestCase控制器类
 * @author cat
 *
 */
@RestController
@RequestMapping("/testcase")
public class TestCaseController {

	@Autowired
	private TestCaseService testCaseService;
	
	/**
	 * 通过id获取testCase资源
	 * @param testCaseId
	 * @return
	 */
	@RequestMapping(value = "/{testCaseId}", method = RequestMethod.GET)
	public TestCase getTestCaseById(@PathVariable("testCaseId") Integer testCaseId){
		return testCaseService.getTestCaseByKey(testCaseId);
	}

	/**
	 * 获取所有testcase资源
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<TestCase> findAllTestCase(){
		return testCaseService.findAllTestCase();
	}
	
	/**
	 * 分页获取testcase资源
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value = "/{currentPage}/list", method = RequestMethod.GET)
	public PageUtils findTestCasesByPage(@PathVariable("currentPage") Integer currentPage){
		return testCaseService.findTestCasesByPage(currentPage);
	}
	
	/**
	 * 添加一个testcase
	 * @param testCase
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTestCase(@RequestBody TestCase testCase){
		testCaseService.addTestCase(testCase);
		return "redirect:/";
	}
	
	/**
	 * 修改一个testcase的数据
	 * @param testCase
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateTestCase(@RequestBody TestCase testCase){
		testCaseService.updateTestCase(testCase);
		return "redirect:/";
	}
	
    /**
     * 批量删除TestCase
     * @param testCaseIds
     * @return
     */
    @RequestMapping(value = "/deletes", method = RequestMethod.DELETE)
    public String deleteTestCase(@RequestBody List<Integer> testCaseIds){
    	testCaseService.deleteTestCases(testCaseIds);
    	return "redirect:/";
    }
    
    /**
     * 单个记录删除TestCase
     * @param testCaseId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteTestCase(Integer testCaseId){
    	testCaseService.deleteTestCaseByKey(testCaseId);
    	return "redirect:/";
    }
	
}
