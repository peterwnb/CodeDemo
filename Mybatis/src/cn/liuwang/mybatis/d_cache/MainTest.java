package cn.liuwang.mybatis.d_cache;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.liuwang.mybatis.util.MyBatisUtils;

public class MainTest {

	@Test
	public void testName() throws Exception {
		SqlSession session = MyBatisUtils.getSession();
		List<User> users = session.selectList("cn.liuwang.mybatis.d_cache.DomainMapper.findAll");
		System.out.println(users.size());
		session.close();
		
		
		SqlSession session2 = MyBatisUtils.getSession();
		List<User> users2 = session2.selectList("cn.liuwang.mybatis.d_cache.DomainMapper.findAll");
		System.out.println(users2.size());
		session2.close();
	}
}
