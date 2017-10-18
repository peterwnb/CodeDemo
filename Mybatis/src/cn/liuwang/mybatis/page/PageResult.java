package cn.liuwang.mybatis.page;

import java.util.List;

public class PageResult<T>
{
	private Integer currentPage;
	private Integer prePage;
	private Integer nextPage;
	private Integer totalPage;
	
	private Integer totalCount;
	private Integer pageSize = 10;
	
	private List<T> datas;
	
	private Integer beginIndex;
	private Integer endIndex;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPrePage() {
		return prePage;
	}

	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	public Integer getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	

	@Override
	public String toString() {
		return "PageResult [currentPage=" + currentPage + ", prePage="
				+ prePage + ", nextPage=" + nextPage + ", totalPage="
				+ totalPage + ", totalCount=" + totalCount + ", pageSize="
				+ pageSize + ", datas=" + datas + ", beginIndex=" + beginIndex
				+ ", endIndex=" + endIndex + "]";
	}

	public PageResult(Integer currentPage, Integer totalCount,
			Integer pageSize, List<T> datas) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.datas = datas;
		
		this.totalPage = this.totalCount % this.pageSize > 0 ? this.totalCount / this.pageSize + 1 : this.totalCount / this.pageSize; 
		this.prePage = this.currentPage > 1 ? this.currentPage - 1 : 1;
		this.nextPage = this.currentPage + 1 < this.totalPage ? this.currentPage + 1 : this.totalPage;
		
		PageIndex pageIndex = PageIndex.getPageIndex(this.pageSize, this.currentPage, this.totalPage);
		this.beginIndex = pageIndex.getBeginIndex();
		this.endIndex = pageIndex.getEndIndex();
	}
}
