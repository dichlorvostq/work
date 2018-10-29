package com.gkhn.wms.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Linkbuyer {
       private int OWNERID;
       private int GOODID;
       private Long  LINKID;
       private int  BUYERID;
       private String  WAREBRAND;
       private String CREATEDATE;
       private int  CREATEUSER;
       private String  MARK;
       
       private String  deptname;
       private String  linkcode;
       private String  linkname;
       private String  goods;
       private String  name;
       private String  spec;
       private String  msunitno;
       private String  packnum;
       private String  producer;
       private String  goodsbrand;
 
       private String  empname;
       private String  buyername;
       private String  createempcode;
       private  String createempname;
       private  int BUYERIDS;
       
	 
       
       
	public Long getLINKID() {
		return LINKID;
	}
	public void setLINKID(Long lINKID) {
		LINKID = lINKID;
	}
	public int getBUYERIDS() {
		return BUYERIDS;
	}
	public void setBUYERIDS(int bUYERIDS) {
		BUYERIDS = bUYERIDS;
	}
	public int getCREATEUSER() {
		return CREATEUSER;
	}
	public void setCREATEUSER(int cREATEUSER) {
		CREATEUSER = cREATEUSER;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getLinkcode() {
		return linkcode;
	}
	public void setLinkcode(String linkcode) {
		this.linkcode = linkcode;
	}
	public String getLinkname() {
		return linkname;
	}
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getMsunitno() {
		return msunitno;
	}
	public void setMsunitno(String msunitno) {
		this.msunitno = msunitno;
	}
	public String getPacknum() {
		return packnum;
	}
	public void setPacknum(String packnum) {
		this.packnum = packnum;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getGoodsbrand() {
		return goodsbrand;
	}
	public void setGoodsbrand(String goodsbrand) {
		this.goodsbrand = goodsbrand;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getBuyername() {
		return buyername;
	}
	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}
	public String getCreateempcode() {
		return createempcode;
	}
	public void setCreateempcode(String createempcode) {
		this.createempcode = createempcode;
	}
	public String getCreateempname() {
		return createempname;
	}
	public void setCreateempname(String createempname) {
		this.createempname = createempname;
	}
	public String getCREATEDATE() {
		return CREATEDATE;
	}
	public void setCREATEDATE(String cREATEDATE) {
		CREATEDATE = cREATEDATE;
	}
	 
	public int getOWNERID() {
		return OWNERID;
	}
	public void setOWNERID(int oWNERID) {
		OWNERID = oWNERID;
	}
	public int getGOODID() {
		return GOODID;
	}
	public void setGOODID(int gOODID) {
		GOODID = gOODID;
	}
	 
	public int getBUYERID() {
		return BUYERID;
	}
	public void setBUYERID(int bUYERID) {
		BUYERID = bUYERID;
	}
	public String getWAREBRAND() {
		return WAREBRAND;
	}
	public void setWAREBRAND(String wAREBRAND) {
		WAREBRAND = wAREBRAND;
	}
	 
	 
	public String getMARK() {
		return MARK;
	}
	public void setMARK(String mARK) {
		MARK = mARK;
	}
       
       
       
}
