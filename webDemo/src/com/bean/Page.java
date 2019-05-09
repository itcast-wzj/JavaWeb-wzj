package com.bean;

import com.consts.MyConst;

public class Page {
	private int pageNum;
	private int startNum;
	
	public Page(int pageNum) {
		super();
		this.pageNum = pageNum;
		//
		startNum = (pageNum-1)*MyConst.PAGESIZE;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	
}
