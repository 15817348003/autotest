package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.dao.TestModuleDao;
import com.fortytwoq.mvc.model.TestModule;
import com.fortytwoq.mvc.service.ITestModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by Wilson.Ke
 */
@Service
public class TestModuleService extends BaseService<TestModule> implements ITestModuleService {
	
    @Autowired
	private TestModuleDao testModuleDao;
}
