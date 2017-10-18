package cn.liuwang.mybatis.query;

public interface IBaseQuery 
{
	public Integer getBeginIndex();
	
	public Integer getCurrentPage();
	public void setCurrentPage(Integer currentPage);
	
	public Integer getPageSize();
	public void setPageSize(Integer pageSize);
	
	public String getOrderBySql();
	
	public String getOrderBy();
	public void setOrderBy(String orderBy);
	
	public String getOrderType();
	public void setOrderType(String orderType);
}
