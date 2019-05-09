package com.dao;

import java.util.List;

import com.bean.Page;
import com.bean.User;

public interface UserDao {
	
	//根据用户名密码查询
	boolean SelectByUP(User user);
	
	//总记录数
	int selectCount();
	
	//总页数 = 总记录数 / 每页记录数
	int selectPageCount();
	
	List<User> selectByPage(Page page);
}
