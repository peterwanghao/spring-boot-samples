package com.peterwanghao.samples.springboot.autoconfiguration.example;

import org.springframework.data.jpa.repository.JpaRepository;

/**   
 * @ClassName:  MyUserRepository
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date:   2019年2月21日 下午4:47:18
 * @version V1.0
 * 
 */
public interface MyUserRepository extends JpaRepository<MyUser, String> {

}
