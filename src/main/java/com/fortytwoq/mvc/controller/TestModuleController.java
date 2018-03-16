package com.fortytwoq.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.TestModule;
import com.fortytwoq.mvc.service.impl.TestModuleService;

/**
 * TestModule控制器类
 * @author cat
 *
 */
@RestController
@RequestMapping("/testmodule")
public class TestModuleController {

	@Autowired
	private TestModuleService testModuleService;
	
	/**
	 * 通过id获取testModule资源
	 * @param testModuleId
	 * @return
	 */
	@RequestMapping(value = "/{testModuleId}", method = RequestMethod.GET)
	public TestModule getTestModuleById(@PathVariable("testModuleId") Integer testModuleId){
		return testModuleService.getTestModuleByKey(testModuleId);
	}

	/**
	 * 获取所有testmodule资源
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<TestModule> findAllTestModule(){
		return testModuleService.findAllTestModule();
	}
	
	/**
	 * 分页获取testmodule资源
	 * @param currentPage
	 * @return
	 */
	@RequestMapping(value = "/{currentPage}/list", method = RequestMethod.GET)
	public PageUtils findTestModulesByPage(@PathVariable("currentPage") Integer currentPage){
		return testModuleService.findTestModulesByPage(currentPage);
	}
	
	/**
	 * 添加一个testmodule
	 * @param testModule
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTestModule(@RequestBody TestModule testModule){
		testModuleService.addTestModule(testModule);
		return "redirect:/";
	}
	
	/**
	 * 修改一个testmodule的数据
	 * @param testModule
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateTestModule(@RequestBody TestModule testModule){
		testModuleService.updateTestModule(testModule);
		return "redirect:/";
	}
	
    /**
     * 批量删除TestModule
     * @param testModuleIds
     * @return
     */
    @RequestMapping(value = "/deletes", method = RequestMethod.DELETE)
    public String deleteTestModule(@RequestBody List<Integer> testModuleIds){
    	testModuleService.deleteTestModules(testModuleIds);
    	return "redirect:/";
    }
    
    /**
     * 单个记录删除TestModule
     * @param testModuleId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteTestModule(Integer testModuleId){
    	testModuleService.deleteTestModuleByKey(testModuleId);
    	return "redirect:/";
    }
	
}
