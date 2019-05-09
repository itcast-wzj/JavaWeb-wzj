package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Page;
import com.bean.User;
import com.consts.MyConst;
import com.dao.UserDao;
import com.utils.DBUtils;

public class UserDaoImpl implements UserDao{
	
	private Connection conn;
	
	public UserDaoImpl() {
		super();
		if(null == conn){
			conn = DBUtils.getConn();
		}
	}

	@Override
	public boolean SelectByUP(User user) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user where username = ? and password = ?");
			//设置占位符,因为都是String类型的,所以setString()即可
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			//因为通过用户名和密码查出来的用户只有一个,所以只有一条记录
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int selectCount() {
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from user");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int selectPageCount() {
		return selectCount() % MyConst.PAGESIZE == 0 ? selectCount() / MyConst.PAGESIZE : selectCount() / MyConst.PAGESIZE+1;
	}

	@Override
	public List<User> selectByPage(Page page) {
		List<User> users = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from user limit ?,?");
			ps.setInt(1,page.getStartNum());
			ps.setInt(2,MyConst.PAGESIZE);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
