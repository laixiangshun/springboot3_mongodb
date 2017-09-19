package com.lai;

import com.lai.dao.UserDao;
import com.lai.model.User;
import com.lai.model.primary.PrimaryMongoObject;
import com.lai.model.secondary.SecondaryMongoObject;
import com.lai.repository.primary.PrimaryRepository;
import com.lai.repository.secondary.SecondaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot3ApplicationTests {

	@Test
	public void contextLoads() {
	}

	//MongoDB --MongoTmplate操作测试
//	@Autowired
//	private UserDao userDao;
//	@Test
//	public void testSaveUser(){
//		User user=new User();
//		user.setId(1L);
//		user.setUserName("aaa");
//		user.setPassword("111");
//		userDao.saveUser(user);
//		System.out.println("add success");
//	}
//	@Test
//	public void testFindUserByName(){
//		User user=userDao.findUserByUserName("aaa");
//		System.out.println("user is" + user);
//	}
//	@Test
//	public void testUpdateUser(){
//		User user=new User();
//		user.setId(1L);
//		user.setUserName("bbb");
//		user.setPassword("222");
//		userDao.updateUser(user);
//		System.out.println("update success");
//	}
//	@Test
//	public void testDeleteUser(){
//		userDao.deleteUserById(2L);
//		System.out.println("delete success");
//	}


	/**
	 * Mongodb多数据源情况测试
	 */

	@Autowired
	private PrimaryRepository primaryRepository;
	@Autowired
	private SecondaryRepository secondaryRepository;

	@Test
	public void testSave(){
		System.out.println("****************************");
		System.out.println("测试开始");
		System.out.println("*******************************");

		this.primaryRepository.save(new PrimaryMongoObject(null, "第一个库对象"));
		this.secondaryRepository.save(new SecondaryMongoObject(null,"第二个库对象"));

		List<PrimaryMongoObject> primaries=this.primaryRepository.findAll();
		for(PrimaryMongoObject primary:primaries){
			System.out.println(primary.toString());
		}
		List<SecondaryMongoObject> secondaries=this.secondaryRepository.findAll();
		for(SecondaryMongoObject secondary: secondaries){
			System.out.println(secondary.toString());
		}
		System.out.println("****************************");
		System.out.println("测试结束");
		System.out.println("*******************************");
	}
}
