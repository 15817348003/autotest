package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.dao.UserMapper;
import com.fortytwoq.mvc.model.User;
import com.fortytwoq.mvc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

import javax.annotation.Resource;

/**
 * Created by Wilson.Ke
 */
@Service("userService")
public class UserService implements IUserService {
	
    @Autowired
    @Qualifier("userMapper") //this is to specify implementation class
	private UserMapper userMapper;

	public User getUser(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	public int addUser(User record) {
		return userMapper.insertSelective(record);
	}
}
