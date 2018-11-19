package com.gkhn.wms.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.SalesDetail;
import com.gkhn.wms.pojo.Selleeruploadqty;
import com.gkhn.wms.service.SelleeruploadqtyService;
import com.gkhn.wms.util.JsonResult;

@Controller
public class SelleeruploadqtyController {
	
	@Autowired  SelleeruploadqtyService   selleeruploadqtyService ;
	  
		   @RequestMapping("selectSelleeruploadqtyLists")
			@ResponseBody
			 public Object selectSelleeruploadqtyList(  HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit) throws UnsupportedEncodingException{
				
				GclasVo x=new GclasVo();
				int a=  limit * ( page - 1 ) ;
				int b= limit * page;
				x.setPage(b);
			    x.setLimit(a);
			    String gongysid2=request.getParameter("gongysid2");
			    if(gongysid2!=null && gongysid2!="") {
			    	gongysid2 = new String(gongysid2.getBytes("iso-8859-1"),"utf-8");
				  }
			    x.setSupcode_bth(null);
			    if(gongysid2!=null || gongysid2!=""){
					 x.setSupcode_bth(gongysid2);
				} 
			    
				
				 String  spid=request.getParameter("spid");
				 x.setGoods(null);
				if(spid!=null || spid!=""){
					 x.setGoods(spid);
				} 
				
				 HttpSession session = request.getSession();
				int empID=(Integer) session.getAttribute("empID");// emp 表 empid
			    x.setEmpid(empID);
			    System.out.println(gongysid2+"供应商"+ spid+" 商品id"+ empID+" <---empID");
			    
				List<Selleeruploadqty>  aa= selleeruploadqtyService.selectSelleeruploadqty(x);  
				int c=selleeruploadqtyService.selectSelleeruploadqtyCount(x);
				 JsonResult aJsonResult=new JsonResult();
				 aJsonResult.setData(aa);
				 aJsonResult.setCount(c);
				 return aJsonResult;  
				}
	   }
 
