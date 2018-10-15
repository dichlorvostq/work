 package com.gkhn.wms.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gkhn.wms.pojo.Linkbuyer;
import com.gkhn.wms.pojo.LinkbuyerVo;
import com.gkhn.wms.pojo.Meun;
import com.gkhn.wms.pojo.Odept;
import com.gkhn.wms.service.LinkbuyerService;
import com.gkhn.wms.service.OPdeptServcie;
import com.gkhn.wms.util.DbcontextHolder;
import com.gkhn.wms.util.JsonResult;

@Controller
@RequestMapping("")
public class LinkBuyerController {
      
   @Autowired  	 LinkbuyerService  linkbuyerService;
   @Autowired  	 OPdeptServcie  opdeptService;
	
	@RequestMapping("/linkbuyer")
	@ResponseBody
	public Object selectLinkbuyerList(HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit) throws UnsupportedEncodingException {
		
		/* HttpSession session = request.getSession();
		 String loginName = (String)session.getAttribute("loginName");
		String  name=request .getParameter("name");
		 if(name!=null && name!="") {
			  name = new String(name.getBytes("iso-8859-1"),"utf-8");
		  }*/
		
	    DbcontextHolder.setDbType("OracledataSource");
		 page = (page-1) * 10 ;
		LinkbuyerVo  lk=new LinkbuyerVo();
		lk.setEmpId(0);    //这里需要从 人员表带出  人员empId  （先模拟一个）
		List<Linkbuyer> list= linkbuyerService.selectLinkbuyerList(lk);
		int counts=linkbuyerService.selectBuyerCount(lk);
		  System.out.println(counts+"这里是查询表后的总条数");
		
		 JsonResult aJsonResult=new JsonResult();
		 aJsonResult.setCount(counts);
		 aJsonResult.setData(list);
		 return aJsonResult; 
		 
	}
	
	@RequestMapping("/ChooseDepartments")
	@ResponseBody
	
public Object selectOdeptList(HttpServletRequest request ,Map<String,Object>map) throws UnsupportedEncodingException {
	     DbcontextHolder.setDbType("OracledataSource");
		 List<Odept> list= opdeptService.selectDeptList();
		 JsonResult aJsonResult=new JsonResult();
		 aJsonResult.setData(list);
		 return aJsonResult; 
	}
}
