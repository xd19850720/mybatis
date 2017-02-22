package com.kaikeba.dao;

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

public class MybatisFirst {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException{
		String resource = "SqlMapConfig.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = null;
		try {
			user = sqlSession.selectOne("test.findUserById", 1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}

		System.out.println(user);
	}
	
	@Test
	public void testFindUsers() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> users = null;
		try {
			users = sqlSession.selectList("test.findUserByName", "小明");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}
		for (User user : users) {
			System.out.println(user.getUsername());
		}
	}
	
	@Test
	public void testInsertUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			User user = new User();
			user.setId(2);
			user.setUsername("xuda");
			user.setBirthday(new Date());
			user.setAddress("北京石景山");
			user.setSex("2");
			sqlSession.insert("test.insertUser", user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}
	}
	@Test
	public void testDeleteUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.delete("test.deleteUserById", 1);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}
	}
	@Test
	public void testUpdateUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			User user = new User();
			user.setId(2);
			user.setUsername("xuda1");
			user.setBirthday(new Date());
			user.setAddress("北京石景山");
			user.setSex("2");
			sqlSession.update("test.updateUserById", user);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭sqlSession
			sqlSession.close();
		}
	}
}
