package com.fortytwoq.mvc.service;

import com.fortytwoq.mvc.model.Project;
import com.fortytwoq.mvc.model.User;

/**
 * Created by Wilson.Ke
 */
public interface IProjectService {

    public Project getProjectByKey(Integer projectId);

    public void addProject(Project project);

}
