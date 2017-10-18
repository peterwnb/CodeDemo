package cn.liuwang.mybatis.query;

import com.mysql.jdbc.StringUtils;

public class BaseQuery implements IBaseQuery {

	//当前
	private Integer currentPage = 1;
	//每页数量
	private Integer pageSize = 10;
	
	private String orderBy;
	
	private String orderType;
		
	public Integer getBeginIndex() {
		return (this.currentPage - 1) * this.pageSize;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	/*
	 * 高级查询时，不会传入currentPage,要做兼容性处理
	 */
	public void setCurrentPage(Integer currentPage) {
		if(null != currentPage)
			this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderBySql() {
		if(null != this.orderBy && "" != this.orderBy)
			return " order by " + this.orderBy + " " + this.orderType;
		return "";
	}
}
