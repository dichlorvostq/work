package com.gkhn.wms.pojo;

import java.sql.Timestamp;
import java.util.Date;

import oracle.sql.DATE;

public class SalesDetail {
       private int id;
       private String billno;
       private String  createdate;
       private String   empname;
       private String  cstcode;
       private String dname;
       private String  goods;
       private String  marketno;
       private String  name;
       private String  spec;
       private int  packnum;
       private String  warebrand;
       private int  billqty;
       private double  prc;
       private double  sumvalue;
       private double  taxrate;
       private String  invoicedate;
       private String  invoiceno;
       private  String deptname;
       private  String  bthdesc;
       private  String   flowname;
       private  String gname;
       private String woempcode;
       private String woempname;
       private String backreasonname;
       private String yddate;
       private String curempname;
       private String osbillno;
       private String  linkcode_bth;
       private String linkname_bth;
       private String supcode_bth;
       private String supname_bth;
       private String indate;
       private String buyercode;
       private  String buyername;
       private double  inprc;
       private  long  batchid;
       private double  invcnt;
       private String  ddeptname;
       private String  kname;
       private String aa;
       private String bb;
       private String cc;
       private String dd;
       
       
       
	 
	public String getAa() {
		return aa;
	}
	public void setAa(String aa) {
		this.aa = aa;
	}
	public String getBb() {
		return bb;
	}
	public void setBb(String bb) {
		this.bb = bb;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public String getLinkcode_bth() {
		return linkcode_bth;
	}
	public void setLinkcode_bth(String linkcode_bth) {
		this.linkcode_bth = linkcode_bth;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getCstcode() {
		return cstcode;
	}
	public void setCstcode(String cstcode) {
		this.cstcode = cstcode;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getMarketno() {
		return marketno;
	}
	public void setMarketno(String marketno) {
		this.marketno = marketno;
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
	public int getPacknum() {
		return packnum;
	}
	public void setPacknum(int packnum) {
		this.packnum = packnum;
	}
	public String getWarebrand() {
		return warebrand;
	}
	public void setWarebrand(String warebrand) {
		this.warebrand = warebrand;
	}
	public int getBillqty() {
		return billqty;
	}
	public void setBillqty(int billqty) {
		this.billqty = billqty;
	}
	public double getPrc() {
		return prc;
	}
	public void setPrc(double prc) {
		this.prc = prc;
	}
	public double getSumvalue() {
		return sumvalue;
	}
	public void setSumvalue(double sumvalue) {
		this.sumvalue = sumvalue;
	}
	public double getTaxrate() {
		return taxrate;
	}
	public void setTaxrate(double taxrate) {
		this.taxrate = taxrate;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getBthdesc() {
		return bthdesc;
	}
	public void setBthdesc(String bthdesc) {
		this.bthdesc = bthdesc;
	}
	public String getFlowname() {
		return flowname;
	}
	public void setFlowname(String flowname) {
		this.flowname = flowname;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getWoempcode() {
		return woempcode;
	}
	public void setWoempcode(String woempcode) {
		this.woempcode = woempcode;
	}
	public String getWoempname() {
		return woempname;
	}
	public void setWoempname(String woempname) {
		this.woempname = woempname;
	}
	public String getBackreasonname() {
		return backreasonname;
	}
	public void setBackreasonname(String backreasonname) {
		this.backreasonname = backreasonname;
	}
	public String getYddate() {
		return yddate;
	}
	public void setYddate(String yddate) {
		this.yddate = yddate;
	}
	public String getCurempname() {
		return curempname;
	}
	public void setCurempname(String curempname) {
		this.curempname = curempname;
	}
	public String getOsbillno() {
		return osbillno;
	}
	public void setOsbillno(String osbillno) {
		this.osbillno = osbillno;
	}
	 
	public String getLinkname_bth() {
		return linkname_bth;
	}
	public void setLinkname_bth(String linkname_bth) {
		this.linkname_bth = linkname_bth;
	}
	public String getSupcode_bth() {
		return supcode_bth;
	}
	public void setSupcode_bth(String supcode_bth) {
		this.supcode_bth = supcode_bth;
	}
	public String getSupname_bth() {
		return supname_bth;
	}
	public void setSupname_bth(String supname_bth) {
		this.supname_bth = supname_bth;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getBuyercode() {
		return buyercode;
	}
	public void setBuyercode(String buyercode) {
		this.buyercode = buyercode;
	}
	public String getBuyername() {
		return buyername;
	}
	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}
	public double getInprc() {
		return inprc;
	}
	public void setInprc(double inprc) {
		this.inprc = inprc;
	}
	public long getBatchid() {
		return batchid;
	}
	public void setBatchid(long batchid) {
		this.batchid = batchid;
	}
	public double getInvcnt() {
		return invcnt;
	}
	public void setInvcnt(double invcnt) {
		this.invcnt = invcnt;
	}
	public String getDdeptname() {
		return ddeptname;
	}
	public void setDdeptname(String ddeptname) {
		this.ddeptname = ddeptname;
	}
       
       
       
       
       
       
	 
	 
       
 
       
}
