package com.peterwanghao.samples.springboot.autoconfiguration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.peterwanghao.samples.springboot.autoconfiguration.example.AutoconfigurationApplication;
import com.peterwanghao.samples.springboot.autoconfiguration.example.MyUser;
import com.peterwanghao.samples.springboot.autoconfiguration.example.MyUserRepository;

/**   
 * @ClassName:  AutoconfigurationLiveTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2019年2月21日 下午5:01:21
 * @version V1.0
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AutoconfigurationApplication.class)
@EnableJpaRepositories(basePackages = { "com.peterwanghao.samples.springboot.autoconfiguration.example" })
public class AutoconfigurationLiveTest {

    @Autowired
    private MyUserRepository userRepository;

    @Test
    public void whenSaveUser_thenOk() {
        MyUser user = new MyUser("user@email.com");
        userRepository.save(user);
    }

}
