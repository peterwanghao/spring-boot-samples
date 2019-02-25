package com.peterwanghao.samples.springboot.autoconfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.peterwanghao.samples.springboot.autoconfiguration.example.AutoconfigurationApplication;

/**   
 * @ClassName:  SpringContextLiveTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2019年2月21日 下午4:58:23
 * @version V1.0
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AutoconfigurationApplication.class)
@EnableJpaRepositories(basePackages = { "com.peterwanghao.samples.springboot.autoconfiguration.example" })
public class SpringContextLiveTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
