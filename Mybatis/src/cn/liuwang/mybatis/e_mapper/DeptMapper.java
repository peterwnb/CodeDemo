package cn.liuwang.mybatis.e_mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

public interface DeptMapper {
	@Delete("delete from t_dept where id=#{id}")
	void delete(Long id);
	
	@Select("select id,name from t_dept where id=#{id}")
	Dept get(Long id);
	
	List<Dept> getAll();
}
