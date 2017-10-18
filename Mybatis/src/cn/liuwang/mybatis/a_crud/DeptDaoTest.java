package cn.liuwang.mybatis.a_crud;

import org.junit.Test;

public class DeptDaoTest {

	DeptDao deptDao = new DeptDao();
	
	public void testSave() {
		Dept dept =new Dept();
		dept.setName("部门1");
		System.out.println(dept);
		deptDao.save(dept);
		System.out.println(dept); 
	}

	public void testUpdate() {
		Dept dept= deptDao.get(1L);
		System.out.println(dept);
		
		dept.setName("xxxx");
		deptDao.update(dept);
		
		dept= deptDao.get(1L);
		System.out.println(dept);
	}

	public void testDelete() {
		deptDao.delete(1L);
	}

	@Test
	public void testGetAll() {
		System.out.println(deptDao.getAll());
	}

}
