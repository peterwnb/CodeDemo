package cn.liuwang.mybatis.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.liuwang.mybatis.page.PageResult;
import cn.liuwang.mybatis.query.IBaseQuery;
import cn.liuwang.mybatis.util.MybatisUtil;

public class BaseDaoImpl<T> implements IBaseDao<T> 
{
	private Class clazz = null;
	public BaseDaoImpl()
	{
		ParameterizedType genericParameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) genericParameterizedType.getActualTypeArguments()[0];
	}
	@Override
	public void save(T t) {
		SqlSession sesseion = null;
		try 
		{
			sesseion = MybatisUtil.INSTANCE.getSession();
			sesseion.insert(this.clazz.getName()+"Mapper.save", t);
			sesseion.commit();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			sesseion.rollback();
		}
		finally
		{
			MybatisUtil.INSTANCE.close(sesseion);
		}
	}

	@Override
	public void remove(Long id) {
		SqlSession sesseion = null;
		try 
		{
			sesseion = MybatisUtil.INSTANCE.getSession();
			sesseion.delete(this.clazz.getName()+"Mapper.remove", id);
			sesseion.commit();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			sesseion.rollback();
		}
		finally
		{
			MybatisUtil.INSTANCE.close(sesseion);
		}
	}

	@Override
	public void update(T t) {
		SqlSession sesseion = null;
		try 
		{
			sesseion = MybatisUtil.INSTANCE.getSession();
			sesseion.update(this.clazz.getName()+"Mapper.update", t);
			sesseion.commit();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			sesseion.rollback();
		}
		finally
		{
			MybatisUtil.INSTANCE.close(sesseion);
		}
	}

	@Override
	public T loadById(Long id) {
		SqlSession sesseion = null;
		try 
		{
			sesseion = MybatisUtil.INSTANCE.getSession();
			return sesseion.selectOne(this.clazz.getName()+"Mapper.loadById", id);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			MybatisUtil.INSTANCE.close(sesseion);
		}
		return null;
	}

	@Override
	public List<T> loadAll(IBaseQuery query) {
		SqlSession sesseion = null;
		try 
		{
			sesseion = MybatisUtil.INSTANCE.getSession();
			//query.setPageSize(-1);
			return sesseion.selectList(this.clazz.getName()+"Mapper.loadAll", query);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			MybatisUtil.INSTANCE.close(sesseion);
		}
		return null;
	}
	@Override
	public PageResult<T> loadByPage(IBaseQuery query) {
		SqlSession sesseion = null;
		try 
		{
			sesseion = MybatisUtil.INSTANCE.getSession();
			
			List<T> dates = sesseion.selectList(this.clazz.getName()+"Mapper.loadAll", query);
			Integer totalCount = sesseion.selectOne(this.clazz.getName()+"Mapper.getTotalCount", query);
			PageResult<T> pageRerult = new PageResult<T>(query.getCurrentPage(), totalCount, query.getPageSize(), 
					dates);
			return pageRerult;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			MybatisUtil.INSTANCE.close(sesseion);
		}
		return null;
	}
	@Override
	public T findOne(String statement, Object obj) {
		SqlSession sesseion = null;
		try 
		{
			sesseion = MybatisUtil.INSTANCE.getSession();
			return sesseion.selectOne(statement, obj);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			MybatisUtil.INSTANCE.close(sesseion);
		}
		return null;
	}
	@Override
	public List<T> findByCount(String statement, Object obj) {
		SqlSession sesseion = null;
		try 
		{
			sesseion = MybatisUtil.INSTANCE.getSession();
			return sesseion.selectList(statement, obj);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			MybatisUtil.INSTANCE.close(sesseion);
		}
		return null;
	}
}
