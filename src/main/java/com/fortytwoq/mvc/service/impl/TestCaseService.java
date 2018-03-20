package com.fortytwoq.mvc.service.impl;

import com.fortytwoq.mvc.dao.TestCaseDao;
import com.fortytwoq.mvc.model.TestCase;
import com.fortytwoq.mvc.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Wilson.Ke
 */
@Service
public class TestCaseService extends BaseService<TestCase> implements ITestCaseService {
    @Autowired
	private TestCaseDao testCaseDao;
}
