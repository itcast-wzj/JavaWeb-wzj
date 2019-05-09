package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.runtime.HttpJspBase;

public class MyJsp extends HttpJspBase{
	
	//必须是public,那个jsp继承才能使用className属性
	public String className = "myjp";
	
	@Override
	public void _jspService(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
	}

}
