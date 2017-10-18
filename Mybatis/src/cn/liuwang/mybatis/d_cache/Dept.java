package cn.liuwang.mybatis.d_cache;

import java.io.Serializable;

public class Dept implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3261341832275334743L;
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + "]";
	}

}
