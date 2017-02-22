package daotest;

import java.io.IOException;
import java.io.InputStream;

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
		User user = userMapper.findUserById(2);
		System.out.println(user.getUsername());
	}
}
