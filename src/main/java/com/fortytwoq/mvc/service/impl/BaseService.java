package com.fortytwoq.mvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.dao.BaseDao;
import com.fortytwoq.mvc.service.IBaseService;

public class BaseService<T> implements IBaseService<T> {

	@Autowired
	private BaseDao<T> baseDao;

	public T getByKey(Integer id) {
		return baseDao.queryObject(id);
	}

	public boolean add(T entity) {
		baseDao.save(entity);
		return true;
	}

	/**
	 * 修改entity
	 */
	@Override
	public boolean update(T entity) {
		int result = baseDao.update(entity);
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 通过id删除一个entity
	 */
	@Override
	public boolean deleteByKey(Integer id) {
		int result = baseDao.delete(id);
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 批量删除entity
	 */
	@Override
	public boolean deleteByIds(List<Integer> ids) {
		int result = baseDao.deleteBatch(ids.toArray());
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 分页获取entity currentPage ： 需要获取的当前页
	 */
	@Override
	public PageUtils findByPage(int currentPage) {
		// 获取总数据条数
		int totalCount = baseDao.queryTotal();
		// 设置每页数据数为10
		int pageSize = 10;
		// 设置分页参数
		Map<String, Object> pageMap = new HashMap<>();
		int offset = (currentPage - 1) * pageSize;
		pageMap.put("offset", offset);
		pageMap.put("limit", pageSize);
		// 以更新时间升序排序
		pageMap.put("sidx", "id");
		pageMap.put("order", "asc");
		List<T> list = baseDao.queryList(pageMap);
		PageUtils pageUtils = new PageUtils(list, totalCount, pageSize, currentPage);
		return pageUtils;
	}

	/**
	 * 获取所有entity
	 */
	@Override
	public List<T> findAll() {
		return baseDao.queryList(null);
	}

}
