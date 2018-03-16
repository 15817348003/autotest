package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.dao.ProjectDao;
import com.fortytwoq.mvc.model.Project;
import com.fortytwoq.mvc.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

	/**
	 * 修改project
	 */
	@Override
	public boolean updateProject(Project project) {
		int result = projectDao.update(project);
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 通过id删除一个project
	 */
	@Override
	public boolean deleteProjectByKey(Integer projectId) {
		int result = projectDao.delete(projectId);
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 批量删除project
	 */
	@Override
	public boolean deleteProjects(List<Integer> projectIds) {
		int result = projectDao.deleteBatch(projectIds.toArray());
		if(result > 0){
			return true;
		}
		return false;
	}

	/**
	 * 分页获取project
	 * currentPage ： 需要获取的当前页
	 */
	@Override
	public PageUtils findProjectsByPage(int currentPage) {
		//获取总数据条数
		int totalCount = projectDao.queryTotal();
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
		List<Project> projects = projectDao.queryList(pageMap);
		PageUtils pageUtils = new PageUtils(projects, totalCount, pageSize, currentPage);
		return pageUtils;
	}

	/**
	 * 获取所有project
	 */
	@Override
	public List<Project> findAllProject() {
		return projectDao.queryList(null);
	}
}
