package com.gkhn.wms.pojo;

public class GclasVo {
			  private String name;//查货主 like  查询      
			  
			  private String bhname;//查商品编号 
			  
			  private String empname; //采购员的名字
			  
			  private String  producer;
			  
			  private int roleid;//   权限id
			  
			  private String username;
			  
			  private int empid;
			  
			  private String bumenname; // 用来查ownerid   插入linkbuyer 表的    
			  
			  private int page;
			  private int limit; 
			  
			  private String search;//供应商搜索条件
			  
			  private String supcode_bth;   // 供应商
			  private int ownerid; // 货主
			  private String   linkcode_bth; // 联系人
			  private String  empcode;  // 登录人
			  private String   warebrand; //厂牌
			  private String goods;//商品编码
			  private String starcreatedate;// 开始时间
			  private String endcreatedate;// 结束时间
			  private long cstid;  // cstid
			  private String lotno; // 批号
			  private int qty2017;  // 库存
			  

		  
			  
			public long getCstid() {
				return cstid;
			}

			public void setCstid(long cstid) {
				this.cstid = cstid;
			}

			public String getLotno() {
				return lotno;
			}

			public void setLotno(String lotno) {
				this.lotno = lotno;
			}

			public int getQty2017() {
				return qty2017;
			}

			public void setQty2017(int qty2017) {
				this.qty2017 = qty2017;
			}

			public int getEmpid() {
				return empid;
			}

			public void setEmpid(int empid) {
				this.empid = empid;
			}

			public String getSupcode_bth() {
				return supcode_bth;
			}

			public void setSupcode_bth(String supcode_bth) {
				this.supcode_bth = supcode_bth;
			}

			public int getOwnerid() {
				return ownerid;
			}

			public void setOwnerid(int ownerid) {
				this.ownerid = ownerid;
			}

			public String getLinkcode_bth() {
				return linkcode_bth;
			}

			public void setLinkcode_bth(String linkcode_bth) {
				this.linkcode_bth = linkcode_bth;
			}

			public String getEmpcode() {
				return empcode;
			}

			public void setEmpcode(String empcode) {
				this.empcode = empcode;
			}

			public String getWarebrand() {
				return warebrand;
			}

			public void setWarebrand(String warebrand) {
				this.warebrand = warebrand;
			}

			public String getGoods() {
				return goods;
			}

			public void setGoods(String goods) {
				this.goods = goods;
			}

			public String getStarcreatedate() {
				return starcreatedate;
			}

			public void setStarcreatedate(String starcreatedate) {
				this.starcreatedate = starcreatedate;
			}

			public String getEndcreatedate() {
				return endcreatedate;
			}

			public void setEndcreatedate(String endcreatedate) {
				this.endcreatedate = endcreatedate;
			}

			public String getSearch() {
				return search;
			}

			public void setSearch(String search) {
				this.search = search;
			}

			public int getPage() {
				return page;
			}

			public void setPage(int page) {
				this.page = page;
			}

			public int getLimit() {
				return limit;
			}

			public void setLimit(int limit) {
				this.limit = limit;
			}

			public String getBumenname() {
				return bumenname;
			}

			public void setBumenname(String bumenname) {
				this.bumenname = bumenname;
			}

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public int getRoleid() {
				return roleid;
			}

			public void setRoleid(int roleid) {
				this.roleid = roleid;
			}

			public String getProducer() {
				return producer;
			}

			public void setProducer(String producer) {
				this.producer = producer;
			}

			public String getEmpname() {
				return empname;
			}

			public void setEmpname(String empname) {
				this.empname = empname;
			}

			public String getBhname() {
				return bhname;
			}

			public void setBhname(String bhname) {
				this.bhname = bhname;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
			  
			  
			  
}
