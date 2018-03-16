package com.fortytwoq.mvc.controller;

import com.fortytwoq.mvc.common.utils.PageUtils;
import com.fortytwoq.mvc.model.Project;
import com.fortytwoq.mvc.service.IProjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



/**
 * project 控制器
 * @author cat
 *
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    @Qualifier("projectService") //this is to specify implementation class
    private IProjectService projectService;

    @ResponseBody
    @RequestMapping(value="/{id}",
            method = RequestMethod.GET,
            produces="application/json;charset=UTF-8")
    public Project findProject(@PathVariable("id") Integer id) {
        Project project = projectService.getProjectByKey(id);
        return project;
    }
    
    /**
     * 获取所有project资源
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<Project> findAllProject(){
    	List<Project> projects =projectService.findAllProject();
    	return projects;
    }
    
    /**
     * 分页获取部分project资源
     * @param currentPage
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{currentPage}/list", method = RequestMethod.GET)
    public PageUtils findProjectByPage(@PathVariable("currentPage") Integer currentPage){
    	return projectService.findProjectsByPage(currentPage);
    }
    
    @ResponseBody
    @RequestMapping(value="/hello",
            method = RequestMethod.GET,
            produces="application/json;charset=UTF-8")
    public String hello() {

        return "hello word!";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String addProject(@RequestBody Project project, BindingResult result) {
        projectService.addProject(project);
        return "redirect:/";
    }
    
    /**
     * 更新project数据
     * @param project
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateProject(@RequestBody Project project){
    	projectService.updateProject(project);
    	return "redirect:/";
    }
    
    /**
     * 批量删除project
     * @param projectIds
     * @return
     */
    @RequestMapping(value = "/deletes", method = RequestMethod.DELETE ,produces="application/json;charset=UTF-8")
    public String deleteProjects(@RequestBody List<Integer> projectIds){
    	projectService.deleteProjects(projectIds);
    	return "redirect:/";
    }
    
    /**
     * 单个记录删除project
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteProject(Integer projectId){
    	projectService.deleteProjectByKey(projectId);
    	return "redirect:/";
    }
    
}
