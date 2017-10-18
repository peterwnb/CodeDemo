package cn.liuwang.mybatis.c_onetomany;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.liuwang.mybatis.util.MyBatisUtils;

public class MainTest {

	@Test
	public void testName() throws Exception {
		SqlSession session = MyBatisUtils.getSession();
		
		List<Dept> depts = session.selectList("cn.liuwang.mybatis.c_onetomany.DomainMapper.findAll");
		for (Dept dept : depts) {
			System.out.println(dept);
			System.out.println(dept.getUsers());
		}
		
		session.close();
	}
}
