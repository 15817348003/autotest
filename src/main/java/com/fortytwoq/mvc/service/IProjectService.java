package com.fortytwoq.mvc.service;

import java.util.List;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.Project;

/**
 * Created by Wilson.Ke
 */
public interface IProjectService extends IBaseService<Project> {

/*    public Project getProjectByKey(Integer projectId);

    public void addProject(Project project);

    public boolean updateProject(Project project);
    
    public PageUtils findProjectsByPage(int currentPage);
    
    public List<Project> findAllProject();
    
    public boolean deleteProjectByKey(Integer projectId);
    
    public boolean deleteProjects(List<Integer> projectIds);*/
	
	public Project testQuery();
}
