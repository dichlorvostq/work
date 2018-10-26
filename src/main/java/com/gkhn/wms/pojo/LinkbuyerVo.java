package com.gkhn.wms.pojo;

import java.sql.Date;

public class LinkbuyerVo {
       private int empId;
       private int OWNERID;
       private int startpage;
       private int size;
       private String goodid;
       private String name;
       
       
 

	public String getGoodid() {
		return goodid;
	}

	public void setGoodid(String goodid) {
		this.goodid = goodid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartpage() {
		return startpage;
	}

	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getOWNERID() {
		return OWNERID;
	}

	public void setOWNERID(int oWNERID) {
		OWNERID = oWNERID;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
       
       
       
}
