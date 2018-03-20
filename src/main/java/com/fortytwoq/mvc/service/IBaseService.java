package com.fortytwoq.mvc.service;

import java.util.List;

import com.fortytwoq.mvc.common.utils.PageUtils;

public interface IBaseService<T> {
	public T getByKey(Integer id);

	public boolean add(T entity);

	public boolean update(T entity);

	public PageUtils findByPage(int currentPage);

	public List<T> findAll();

	public boolean deleteByKey(Integer id);

	public boolean deleteByIds(List<Integer> ids);

}
