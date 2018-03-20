package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.dao.ProjectDao;
import com.fortytwoq.mvc.model.Project;
import com.fortytwoq.mvc.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by Wilson.Ke
 */
@Service
public class ProjectService extends BaseService<Project> implements IProjectService {
	
    @Autowired
	private ProjectDao projectDao;

	@Override
	public Project testQuery() {
		return projectDao.testQuery();
	}

}
