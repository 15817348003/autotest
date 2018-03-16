package com.fortytwoq.mvc.test;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * junit测试类的超类，加载spring配置文件，之后spring相关的测试类只需继承此类即可
 * @author cat
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class BaseJunit4Test {
}
