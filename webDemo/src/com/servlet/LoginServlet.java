package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 * 有人会想我表单post请求,你在get请求中写逻辑,因为下面是dopost方法里面,实际上也是调用了doGet()
		 */
		//获取表单提交过来的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		/**
		 * 因为我这里没有什么业务逻辑,就跳过了service层 
		 */
		User user = new User(username, password);
		UserDao dao = new UserDaoImpl();
		boolean flag = dao.SelectByUP(user);
		
		//使用阿里巴巴的fastJson来返回,json把他看成一个map
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", flag ? 1 : 0);
		jsonObject.put("msg", flag ? "success" : "fail");
		System.out.println(jsonObject.toString());
		
		PrintWriter pw = resp.getWriter();
		pw.append(jsonObject.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
