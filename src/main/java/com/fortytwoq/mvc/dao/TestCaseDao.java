package com.fortytwoq.mvc.dao;

import com.fortytwoq.mvc.model.TestCase;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestCaseDao extends BaseDao<TestCase>{
	TestCase queryByCaseName(String caseName);
}