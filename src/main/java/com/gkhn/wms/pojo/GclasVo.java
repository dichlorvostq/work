package com.gkhn.wms.pojo;

public class GclasVo {
			  private String name;//查货主 like  查询     
			  
			  private String bhname;//查商品编号 
			  
			  private String empname; //采购员的名字
			  
			  private String  producer;
			  
			  private int roleid;//   权限id
			  
			  private String username;
			  
			  private String bumenname; // 用来查ownerid   插入linkbuyer 表的    
			  
			  private int page;
			  private int limit; 
			  
			  
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
