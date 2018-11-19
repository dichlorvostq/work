package com.gkhn.wms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.LotnoQurey;
import com.gkhn.wms.service.LotnoQureyService;
import com.gkhn.wms.util.JsonResult;

@Controller
public class LotnoQureyController {
   
	@Autowired  LotnoQureyService   lotnoQureyService; 
	 
	@RequestMapping("selectLotnoQureyLists")
	@ResponseBody
	public Object selectLotnoQureyList (HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit){
		       
		        String  changpai=request.getParameter("changpai");     //厂牌
		        String  lianxirenlxr=request.getParameter("lianxirenlxr"); // 联系人
		        String  shangpbianmid=request.getParameter("shangpbianmid"); // 商品编码
		        String gongysid=request.getParameter("gongysid");//   供应商
		       
			   	 HttpSession session = request.getSession();
				int   ownerid= (Integer) session.getAttribute("ownerid");//所属部门
				/* int ownerids=Integer.parseInt(ownerid);*/
				 GclasVo g=new GclasVo();
				 g.setWarebrand(null);
				 if(changpai!=null && changpai!=""){
					 g.setWarebrand(changpai);
				 }
				 g.setLinkcode_bth(lianxirenlxr);  
				 System.out.println(gongysid+"供应商id");
				 g.setSupcode_bth("null");
				 if(gongysid!=null  && gongysid!=""){
					 g.setSupcode_bth(gongysid);
				 }
				 
				 g.setGoods(shangpbianmid);
				 g.setOwnerid(ownerid);
		 
				 int a=  limit * ( page - 1 ) ;
				 int b= limit * page;
				 g.setLimit(b);
				 g.setPage(a);
		         List<LotnoQurey> list= lotnoQureyService.selectLotnoQureyList(g);
		         int count=lotnoQureyService.selectLotnoQureyCount(g);
		         JsonResult aJsonResult=new JsonResult();
				 aJsonResult.setCount(count);
				 aJsonResult.setData(list);
				 return aJsonResult; 
	}
}
