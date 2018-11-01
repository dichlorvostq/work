package com.gkhn.wms.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.SalesDetail;
import com.gkhn.wms.service.SalesDetailService;
import com.gkhn.wms.util.JsonResult;


@Controller
public class SalesDetailController {
	
	@Autowired SalesDetailService   salesDetailService; 
     
	@RequestMapping("selectSalesDetailList")
	@ResponseBody
	public Object selectSalesDetailList(  HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit){
		
		
		 int a=  limit * ( page - 1 ) ;
		 int b= limit * page;
	    GclasVo x=new GclasVo();
	    x.setPage(a);
	    x.setLimit(b);
		List<SalesDetail>  aa= salesDetailService.SalesDetailList(x);
		int c=salesDetailService.SalesDetailCount(x);
		 JsonResult aJsonResult=new JsonResult();
		 aJsonResult.setData(aa);
		 aJsonResult.setCount(c);
		 return aJsonResult;  
		}	
}
