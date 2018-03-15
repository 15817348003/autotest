package com.fortytwoq.mvc.controller;

import com.fortytwoq.mvc.model.Project;
import com.fortytwoq.mvc.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    @Qualifier("projectService") //this is to specify implementation class
    private IProjectService projectService;

//    @RequestMapping(value = "/",
//            method = RequestMethod.GET,
//            produces="application/json;charset=UTF-8")
//    public String listUsers(ModelMap model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("users", userService.getAllUsers());
//        return "redirect:/";
//    }
//
//    /**
//     *
//     * @return users in json
//     */
//    @ResponseBody
//    @RequestMapping(value = "/json",
//            method = RequestMethod.GET,
//            produces="application/json;charset=UTF-8")
//    public  List<User> listUsers() {
//        List<User> users = userService.getAllUsers();
//        return users;
//    }

    @ResponseBody
    @RequestMapping(value="/{id}",
            method = RequestMethod.GET,
            produces="application/json;charset=UTF-8")
    public Project findProject(@PathVariable("id") Integer id) {
        Project project = projectService.getProjectByKey(id);
        return project;
    }
    
    @ResponseBody
    @RequestMapping(value="/hello",
            method = RequestMethod.GET,
            produces="application/json;charset=UTF-8")
    public String hello() {

        return "hello word!";
    }
    
//    @ResponseBody
//    @RequestMapping(value="/hello/{userId}",
//            method = RequestMethod.GET,
//            produces="application/json;charset=UTF-8")
//    public String hello(@PathVariable("userId") int userId) {
//
//        return "hello word!"+userId;
//    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    public String addProject(@RequestBody Project project, BindingResult result) {
        projectService.addProject(project);
        return "redirect:/";
    }
    
//    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.PUT)
//    public String deleteUser(@PathVariable("userId") int userId) {
//        userService.deleteUser(userId);
//        return "redirect:/";
//    }
}
