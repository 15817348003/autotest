package com.fortytwoq.mvc.controller;

import com.fortytwoq.mvc.model.User;
import com.fortytwoq.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tian Wang on 2015/3/24.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService") //this is to specify implementation class
    private IUserService userService;

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
    @RequestMapping(value="/{userId}",
            method = RequestMethod.GET,
            produces="application/json;charset=UTF-8")
    public User findUser(@PathVariable("userId") Integer userId) {
        User user = userService.getUser(userId);
        return user;
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
    public String addUser(@RequestBody User user, BindingResult result) {
        userService.addUser(user);
        return "redirect:/";
    }
    
//    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.PUT)
//    public String deleteUser(@PathVariable("userId") int userId) {
//        userService.deleteUser(userId);
//        return "redirect:/";
//    }
}
