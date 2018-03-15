package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.dao.ProjectDao;
import com.fortytwoq.mvc.dao.UserMapper;
import com.fortytwoq.mvc.model.Project;
import com.fortytwoq.mvc.model.User;
import com.fortytwoq.mvc.service.IProjectService;
import com.fortytwoq.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

import javax.annotation.Resource;

/**
 * Created by Wilson.Ke
 */
@Service("projectService")
public class ProjectService implements IProjectService {
	
    @Autowired
    @Qualifier("projectDao") //this is to specify implementation class
	private ProjectDao projectDao;

	public Project getProjectByKey(Integer id) {
		return projectDao.queryObject(id);
	}
	
	public void addProject(Project project) {
		projectDao.save(project);;
	}
}
