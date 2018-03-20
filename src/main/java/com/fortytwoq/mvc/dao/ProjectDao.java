package com.fortytwoq.mvc.dao;

import org.apache.ibatis.annotations.Mapper;

import com.fortytwoq.mvc.model.Project;

@Mapper
public interface ProjectDao extends BaseDao<Project> {
	Project queryByProjectName(String projectName);	
	
	Project testQuery();
}
