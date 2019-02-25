package com.peterwanghao.samples.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.peterwanghao.samples.springboot.autoconfiguration.MySQLAutoconfiguration;

/**   
 * @ClassName:  SpringContextLiveTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2019年2月21日 下午4:51:28
 * @version V1.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MySQLAutoconfiguration.class)
@WebAppConfiguration
public class SpringContextLiveTest {
	@Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
