package cn.liuwang.mybatis.f_mapper_map_list;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.liuwang.mybatis.util.MyBatisUtils;

public class MainTest {

	@Test
	public void testGet() throws Exception {
		SqlSession session = MyBatisUtils.getSession();
		
		DeptMapper deptMapper = session.getMapper(DeptMapper.class);
		System.out.println(deptMapper.getClass());
		
		System.out.println(deptMapper.get(1L));
		
		session.commit();
		session.close();
	}
	
	@Test
	public void testGetAll() throws Exception {
		SqlSession session = MyBatisUtils.getSession();
		
		DeptMapper deptMapper = session.getMapper(DeptMapper.class);
		System.out.println(deptMapper.getClass());
		
		System.out.println(deptMapper.getAll());
		
		session.commit();
		session.close();
	}
}
