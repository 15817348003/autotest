package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.dao.TestModuleDao;
import com.fortytwoq.mvc.model.TestModule;
import com.fortytwoq.mvc.service.ITestModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Wilson.Ke
 */
@Service
public class TestModuleService implements ITestModuleService {
	
    @Autowired
	private TestModuleDao testModuleDao;

	public TestModule getTestModuleByKey(Integer id) {
		return testModuleDao.queryObject(id);
	}
	
	public boolean addTestModule(TestModule testModule) {
		testModuleDao.save(testModule);
		return true;
	}

	/**
	 * 修改testModule
	 */
	@Override
	public boolean updateTestModule(TestModule testModule) {
		int result = testModuleDao.update(testModule);
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 通过id删除一个testModule
	 */
	@Override
	public boolean deleteTestModuleByKey(Integer testModuleId) {
		int result = testModuleDao.delete(testModuleId);
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 批量删除testModule
	 */
	@Override
	public boolean deleteTestModules(List<Integer> testModuleIds) {
		int result = testModuleDao.deleteBatch(testModuleIds.toArray());
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 分页获取testModule
	 * currentPage ： 需要获取的当前页
	 */
	@Override
	public PageUtils findTestModulesByPage(int currentPage) {
		//获取总数据条数
		int totalCount = testModuleDao.queryTotal();
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
		List<TestModule> testModules = testModuleDao.queryList(pageMap);
		PageUtils pageUtils = new PageUtils(testModules, totalCount, pageSize, currentPage);
		return pageUtils;
	}

	/**
	 * 获取所有testModule
	 */
	@Override
	public List<TestModule> findAllTestModule() {
		return testModuleDao.queryList(null);
	}
}
