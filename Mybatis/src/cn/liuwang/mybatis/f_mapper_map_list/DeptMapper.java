package cn.liuwang.mybatis.f_mapper_map_list;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;

public interface DeptMapper {
	@Delete("delete from t_dept where id=#{id}")
	void delete(Long id);
	
	HashMap<String, String> get(Long id);
	
	List<HashMap<String, String>> getAll();
}
