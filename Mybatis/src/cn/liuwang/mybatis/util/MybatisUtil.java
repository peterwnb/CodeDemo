package cn.liuwang.mybatis.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public enum MybatisUtil
{
	INSTANCE;
	
	private static SqlSessionFactory factory = null;
	
	static
	{
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getSession()
	{
		return factory.openSession();
	}
	public void close(SqlSession sesseion)
	{
		if(null != sesseion)
		{
			sesseion.close();
		}
	}
}
