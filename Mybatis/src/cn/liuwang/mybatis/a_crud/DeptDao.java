package cn.liuwang.mybatis.a_crud;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.liuwang.mybatis.util.MyBatisUtils;

public class DeptDao {
	public static final String NAME_SPACE = "cn.liuwang.mybatis.a_crud.DeptMapper";

	public void save(Dept dept) {
		SqlSession session = null;
		try { 
			session = MyBatisUtils.getSession();
			session.insert(NAME_SPACE + ".save", dept);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			throw new RuntimeException("dao.save出现异常：" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void update(Dept dept) {
		SqlSession session = null;
		try {
			session = MyBatisUtils.getSession();
			session.update(NAME_SPACE + ".update", dept);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("dao.update出现异常：" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void delete(Long id) {
		SqlSession session = null;
		try {
			session = MyBatisUtils.getSession();
			session.delete(NAME_SPACE + ".delete", id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("dao.delete出现异常：" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Dept get(Long id) {
		SqlSession session = null;
		try {
			session = MyBatisUtils.getSession();
			return session.selectOne(NAME_SPACE + ".get", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("dao.get出现异常：" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public List<Dept> getAll() {
		SqlSession session = null;
		try {
			session = MyBatisUtils.getSession();
			return session.selectList(NAME_SPACE + ".getAll");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("dao.getAll出现异常：" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
