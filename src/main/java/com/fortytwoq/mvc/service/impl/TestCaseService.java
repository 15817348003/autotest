package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.dao.TestCaseDao;
import com.fortytwoq.mvc.model.TestCase;
import com.fortytwoq.mvc.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Wilson.Ke
 */
@Service
public class TestCaseService implements ITestCaseService {
	
    @Autowired
	private TestCaseDao testCaseDao;

	public TestCase getTestCaseByKey(Integer id) {
		return testCaseDao.queryObject(id);
	}
	
	public boolean addTestCase(TestCase testCase) {
		testCaseDao.save(testCase);
		return true;
	}

	/**
	 * 修改testCase
	 */
	@Override
	public boolean updateTestCase(TestCase testCase) {
		int result = testCaseDao.update(testCase);
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 通过id删除一个testCase
	 */
	@Override
	public boolean deleteTestCaseByKey(int testCaseId) {
		int result = testCaseDao.delete(testCaseId);
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 批量删除testCase
	 */
	@Override
	public boolean deleteTestCases(List<Integer> testCaseIds) {
		int result = testCaseDao.deleteBatch(testCaseIds.toArray());
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 分页获取testCase
	 * currentPage ： 需要获取的当前页
	 */
	@Override
	public PageUtils findTestCasesByPage(int currentPage) {
		//获取总数据条数
		int totalCount = testCaseDao.queryTotal();
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
		List<TestCase> testCases = testCaseDao.queryList(pageMap);
		PageUtils pageUtils = new PageUtils(testCases, totalCount, pageSize, currentPage);
		return pageUtils;
	}

	/**
	 * 获取所有testCase
	 */
	@Override
	public List<TestCase> findAllTestCase() {
		return testCaseDao.queryList(null);
	}
}
