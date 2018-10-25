package com.gkhn.wms.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Linkbuyer {
       private int OWNERID;
       private int GOODID;
       private int LINKID;
       private int  BUYERID;
       private String  WAREBRAND;
       private String CREATEDATE;
   
       private String  CREATEUSER;
       private String  MARK;
       
	 
	 
	public String getCREATEDATE() {
		return CREATEDATE;
	}
	public void setCREATEDATE(String cREATEDATE) {
		CREATEDATE = cREATEDATE;
	}
	public String getCREATEUSER() {
		return CREATEUSER;
	}
	public void setCREATEUSER(String cREATEUSER) {
		CREATEUSER = cREATEUSER;
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
	public int getLINKID() {
		return LINKID;
	}
	public void setLINKID(int lINKID) {
		LINKID = lINKID;
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
