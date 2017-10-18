package cn.liuwang.mybatis.dao;

import java.util.List;

import cn.liuwang.mybatis.page.PageResult;
import cn.liuwang.mybatis.query.IBaseQuery;

public interface IBaseDao <T>
{
	void save(T product);
	void remove(Long id);
	void update(T product);
	T loadById(Long id);
	List<T> loadAll(IBaseQuery query);
	PageResult<T> loadByPage(IBaseQuery query);
	
	T findOne(String statement, Object obj);
	
	List<T> findByCount(String statement, Object obj);
}
