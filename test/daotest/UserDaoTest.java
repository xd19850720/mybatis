package daotest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.kaikeba.bean.User;
import com.kaikeba.mapper.UserMapper;

public class UserDaoTest {

private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException{
		int[] a = {1,2,23,3};
		test(a);
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	public void test(int[] mm){
		
	}
	@Test
	public void testFindUserById() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user.getUsername());
	}
	
	@Test
	public void testFindUsersByName() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> users = userMapper.findUserByName("张三");
		System.out.println(users.get(0).getUsername());
	}
	
	@Test
	public void testInsertUser() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = new User();
		user.setId(2);
		user.setAddress("石景山");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setUsername("xuda");
		
		userMapper.insertUser(user);
		session.commit();		
	}
	
	
	@Test
	public void testUpdateUserById() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		User user = new User();
		user.setId(2);
		user.setAddress("石景山");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setUsername("xuda1");
		
		userMapper.updateUserById(user);
		session.commit();		
	}
	
	@Test
	public void testDeleteUser() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		userMapper.deleteUserById(2);
		session.commit();		
	}
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		int count = userMapper.findUserCount(user);
		session.close();
		System.out.println(count);	
	}
}
