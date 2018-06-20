package com.company.core.util;

import com.company.core.mapper.custom.SequenceMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @Author: weiwankun
 * @Date: 2018/3/2
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml", "classpath*:sms-servlet.xml"})
public class SequenceMapperTest extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    SequenceMapper sequenceMapper;
    
     /*
    // 模拟request,response
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void setUp() {
		// request = new MockHttpServletRequest();
		// request.setCharacterEncoding("UTF-8");
		// response = new MockHttpServletResponse();
	}
    */
    
    @Test
    @Rollback(false)
    public void testSequence() throws Exception {
    
        int seq = sequenceMapper.getSequenceNextVal("SMS_ORDER_ID");
        log.info("seq=" + seq);
    }
    
}
