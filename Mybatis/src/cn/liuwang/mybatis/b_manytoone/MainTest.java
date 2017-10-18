package cn.liuwang.mybatis.b_manytoone;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.liuwang.mybatis.util.MyBatisUtils;

public class MainTest {

	@Test
	public void testName() throws Exception {
		SqlSession session = MyBatisUtils.getSession();
		
		List<User> users = session.selectList("cn.liuwang.mybatis.b_manytoone.DomainMapper.findAll");
		for (User user : users) {
			System.out.println(user);
			System.out.println(user.getDept());
		}
		
		session.close();
	}
}
