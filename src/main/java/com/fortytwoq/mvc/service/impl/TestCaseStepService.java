package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.dao.TestCaseStepDao;
import com.fortytwoq.mvc.model.TestCaseStep;
import com.fortytwoq.mvc.service.ITestCaseStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by Wilson.Ke
 */
@Service
public class TestCaseStepService extends BaseService<TestCaseStep> implements ITestCaseStepService {
	
    @Autowired
	private TestCaseStepDao testCaseStepDao;
}
