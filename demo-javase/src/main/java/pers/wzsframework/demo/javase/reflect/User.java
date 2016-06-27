package pers.wzsframework.demo.javase.reflect;

import java.io.Serializable;
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4396770193598096930L;
	private String id;
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "用户id:"+id+",名称:"+userName;
	}
}
