package com.fortytwoq.mvc.dao;

import com.fortytwoq.mvc.model.TestModule;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestModuleDao extends BaseDao<TestModule> {
	TestModule queryByModuleName(String moduleName);
}