package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.dao.TestCaseStepDao;
import com.fortytwoq.mvc.model.TestCaseStep;
import com.fortytwoq.mvc.service.ITestCaseStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Wilson.Ke
 */
@Service
public class TestCaseStepService implements ITestCaseStepService {
	
    @Autowired
	private TestCaseStepDao testCaseStepDao;

	public TestCaseStep getTestCaseStepByKey(Integer id) {
		return testCaseStepDao.queryObject(id);
	}
	
	public boolean addTestCaseStep(TestCaseStep testCaseStep) {
		testCaseStepDao.save(testCaseStep);
		return true;
	}

	/**
	 * 修改testCaseStep
	 */
	@Override
	public boolean updateTestCaseStep(TestCaseStep testCaseStep) {
		int result = testCaseStepDao.update(testCaseStep);
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 通过id删除一个testCaseStep
	 */
	@Override
	public boolean deleteTestCaseStepByKey(int testCaseStepId) {
		int result = testCaseStepDao.delete(testCaseStepId);
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 批量删除testCaseStep
	 */
	@Override
	public boolean deleteTestCaseSteps(List<Integer> testCaseStepIds) {
		int result = testCaseStepDao.deleteBatch(testCaseStepIds.toArray());
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 分页获取testCaseStep
	 * currentPage ： 需要获取的当前页
	 */
	@Override
	public PageUtils findTestCaseStepsByPage(int currentPage) {
		//获取总数据条数
		int totalCount = testCaseStepDao.queryTotal();
		//设置每页数据数为10
		int pageSize = 10;
		//设置分页参数
		Map<String, Object> pageMap = new HashMap<>();
		int offset = (currentPage - 1) * pageSize;
		pageMap.put("offset", offset);
		pageMap.put("limit", pageSize);
		//以更新时间升序排序
		pageMap.put("sidx", "id");
		pageMap.put("order", "asc");
		List<TestCaseStep> testCaseSteps = testCaseStepDao.queryList(pageMap);
		PageUtils pageUtils = new PageUtils(testCaseSteps, totalCount, pageSize, currentPage);
		return pageUtils;
	}

	/**
	 * 获取所有testCaseStep
	 */
	@Override
	public List<TestCaseStep> findAllTestCaseStep() {
		return testCaseStepDao.queryList(null);
	}
}
