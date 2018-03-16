package com.fortytwoq.mvc.service;

import com.fortytwoq.mvc.model.User;

/**
 * Created by Wilson.Ke
 */
public interface IUserService {
//    public List<User> getAllUsers();

    public User getUser(Integer userId);

    public int addUser(User user);
//
//    public void deleteUser(long userId);
}
