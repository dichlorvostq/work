 package com.gkhn.wms.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Linkbuyer;
import com.gkhn.wms.pojo.LinkbuyerVo;
import com.gkhn.wms.pojo.Meun;
import com.gkhn.wms.pojo.Odept;
import com.gkhn.wms.pojo.Olinkman;
import com.gkhn.wms.pojo.Opwaredict;
import com.gkhn.wms.pojo.Owarebrand;
import com.gkhn.wms.pojo.Pubemp;
import com.gkhn.wms.service.IndexService;
import com.gkhn.wms.service.LinkbuyerService;
import com.gkhn.wms.service.OPdeptServcie;
import com.gkhn.wms.service.OlinkmanService;
import com.gkhn.wms.service.OwarebrandService;
import com.gkhn.wms.service.OwaredictService;
import com.gkhn.wms.util.DbcontextHolder;
import com.gkhn.wms.util.JsonResult;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("")
public class LinkBuyerController {
      
   @Autowired  	 LinkbuyerService  linkbuyerService;
   @Autowired  	 OPdeptServcie  opdeptService;
   @Autowired  	 OwaredictService  owaredictService;
   @Autowired  	 OlinkmanService  olinkmanService;
   @Autowired  	 IndexService   indexService ;
   @Autowired      OwarebrandService  owarebrandService;
   
	
	@RequestMapping("/linkbuyer")
	@ResponseBody
	public Object selectLinkbuyerList(HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit) throws UnsupportedEncodingException {
 
	    DbcontextHolder.setDbType("OracledataSource");
	    
	    String  name=request .getParameter("drugname");
	     if(name!=null && name!="") {
			  name = new String(name.getBytes("iso-8859-1"),"utf-8");
		  }
	     System.out.println(name+"搜索的条件");
	     
	    int a=  limit * ( page - 1 ) ;
		 int b= limit * page;
		LinkbuyerVo  lk=new LinkbuyerVo();
		 HttpSession session = request.getSession();
		 String dlcode=(String)session.getAttribute("txusername");
		 int dlcodes=   Integer.parseInt(dlcode);
		  
		 int ownerid =  (Integer) session.getAttribute("ownerid"); 
		 lk.setOWNERID(ownerid);
		 lk.setName(name);
		 lk.setGoodid(name);
		lk.setEmpId(dlcodes);    //这里需要从 人员表带出  人员empId   
		lk.setSize(limit);
		lk.setStartpage(page);
     	lk.setSize(b);
    	lk.setStartpage(a);
		
		List<Linkbuyer> list= linkbuyerService.selectLinkbuyerList(lk);
		int counts=linkbuyerService.selectBuyerCount(lk);
		
		 JsonResult aJsonResult=new JsonResult();
		 aJsonResult.setCount(counts);
		 aJsonResult.setData(list);
		 return aJsonResult; 
		 
	}
	
	//选择部门
	@RequestMapping("/ChooseDepartments")
	@ResponseBody
	
public Object selectOdeptList(HttpServletRequest request ,Map<String,Object>map) throws UnsupportedEncodingException {
	     DbcontextHolder.setDbType("OracledataSource");
	     String  name=request .getParameter("name");
	     if(name!=null && name!="") {
			  name = new String(name.getBytes("iso-8859-1"),"utf-8");
		  }
		 List<Odept> list= opdeptService.selectDeptList(name);
		 JsonResult aJsonResult=new JsonResult();
		 aJsonResult.setData(list);
		 return aJsonResult; 
	}
	
	
	//选择编码
		@RequestMapping("/ChooseCommoditycodes")
		@ResponseBody
		
	public Object selectOwarrdicttList(HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit) throws UnsupportedEncodingException {
		     DbcontextHolder.setDbType("OracledataSource");
		     String s="";
		     String  name=request .getParameter("name");
		     if(name!=null && name!="") {
		    	 name = new String(name.getBytes("iso-8859-1"),"utf-8");
		    	 s=name.toUpperCase();
			  }else{
				   s="消炎";
			  }
		  int a=  limit * ( page - 1 ) ;
		    int b= limit * page;
			 List<Opwaredict> list= owaredictService.selectOpwaredictList(s,a,b);
			 int  aa= owaredictService. selectWaredictListCount(s);
			 
			 JsonResult aJsonResult=new JsonResult();
			 aJsonResult.setCount(aa);
			 aJsonResult.setData(list);
			 return aJsonResult; 
			 
		}
	
		
		
		//选择联系人
		@RequestMapping("/SelectContacts")
		@ResponseBody
		
	public Object selectOlinkmanList(HttpServletRequest request ,Map<String,Object>map ,String id,int page,int limit) throws UnsupportedEncodingException {
		     DbcontextHolder.setDbType("OracledataSource");
		     String  name=request .getParameter("name");
		     if(name!=null && name!="") {
				  name = new String(name.getBytes("iso-8859-1"),"utf-8");
			  }else{
				  name="212";
			  }
		        int a=  limit * ( page - 1 ) ;
			    int b= limit * page;
		     List<Olinkman> list =olinkmanService.selectLinkmanList(name,a,b);
		     int  aa= olinkmanService.selectLinkmanListCount(name);
		     JsonResult aJsonResult=new JsonResult();
			 aJsonResult.setCount(aa);
			 aJsonResult.setData(list);
			 return aJsonResult; 
		}	
		
		
		//选择采购员
		@RequestMapping("/SelectPurchaserss")
		@ResponseBody
		
	public Object selectOcaigouyuanList(HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit) throws UnsupportedEncodingException {
		     DbcontextHolder.setDbType("OracledataSource");
		     String  name=request .getParameter("name");
		     
		     if(name!=null && name!="") {
				  name = new String(name.getBytes("iso-8859-1"),"utf-8");
			  }
		     
		     int a=  limit * ( page - 1 ) ;
			 int b= limit * page;
			 
		     GclasVo n =new GclasVo();
		     n.setLimit(b);
		     n.setPage(a);
		     n.setEmpname(name);
		     List<Pubemp> list =indexService.selectBuyer(n);
		     JsonResult aJsonResult=new JsonResult();
			 aJsonResult.setCount(indexService.selectBuyerCount(n));
			 aJsonResult.setData(list);
			 return aJsonResult; 
		}	
		
		
		//选择厂牌
		@RequestMapping("/Choosebrandss")
		@ResponseBody
		
	public Object selectChoosebrandList(HttpServletRequest request ,Map<String,Object>map) throws UnsupportedEncodingException {
		     DbcontextHolder.setDbType("OracledataSource");
		     String  name=request .getParameter("name");
		     if(name!=null && name!="") {
				  name = new String(name.getBytes("iso-8859-1"),"utf-8");
			  }
		     else{
				  name="湖南";
			  }
		     GclasVo a=new GclasVo();
		     a.setProducer(name);
		     List<Owarebrand> list =owarebrandService.selectWarebrandtList(a);
			 JsonResult aJsonResult=new JsonResult();
			 aJsonResult.setData(list);
			 return aJsonResult; 
		}	
		
		
		
		@RequestMapping("/addLinkbuyer")
		@ResponseBody
		public Object addLinkbuyerone(HttpServletRequest request ,Map<String,Object>map) throws UnsupportedEncodingException {
		     DbcontextHolder.setDbType("OracledataSource");
		     String spbianma =request.getParameter("spbianma");
		     int shangpbm=   Integer.parseInt(spbianma);
		     
		     String lianxiren=request.getParameter("lianxiren");
		      Long lianxirens=  Long.parseLong(lianxiren);
		     
		     String caigouyuan=request.getParameter("caigouyuan");
		     int caigouyuans=   Integer.parseInt(caigouyuan);
		     
		     String cpai =request.getParameter("cpai");
		     HttpSession session = request.getSession();
			 int ownerid =  (Integer) session.getAttribute("ownerid"); 
			 
			  String empcodes =   (String) session.getAttribute("txusername"); 
			  int empID= indexService.selectEmpID(empcodes); 
			  session.setAttribute("empID", empID);
		 
		     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    
		    String b= df.format(new Date());
		   /* Timestamp ftime =Timestamp.valueOf(b);*/
		     Date  a=new Date();
		     System.out.println(b+"<--->"+a);
		     
		     Linkbuyer  dx=new Linkbuyer();
		     dx.setOWNERID(ownerid);
		     dx.setGOODID(shangpbm);
		     dx.setLINKID(lianxirens);
		     dx.setBUYERID(caigouyuans);
		     dx.setWAREBRAND(cpai);
		     dx.setCREATEDATE(b);
		     dx.setCREATEUSER(empID);
		     dx.setMARK(" ");
		     
		     int cc;
				try {
					  cc=  linkbuyerService.addLinkBuyer(dx);
				} catch (Exception e) {
				   cc=0;	 
				}
		     
				System.out.println(cc+"添加的状态");
			 JsonResult aJsonResult=new JsonResult();
			    if(cc>0){
			    	aJsonResult.setState(100);
			    }else{
			    	aJsonResult.setState(200);
			    }
			    System.out.println(aJsonResult.getState()+"返回状态");
			 return aJsonResult; 
		}	
		
		
		
		@RequestMapping("/DelLinkbuyer")
		@ResponseBody
		public Object delLinkbuyerone(HttpServletRequest request ,Map<String,Object>map) throws UnsupportedEncodingException {
			  String goodid=request.getParameter("goodid");
			  int goodids=Integer.parseInt(goodid);
			  String linkid=request.getParameter("linkid");
			  Long linkids=Long.parseLong(linkid);
			  String ownerid=request.getParameter("ownerid");
			  int ownerids=Integer.parseInt(ownerid);
			  String buyerid=request.getParameter("buyerid");
			  int buyerids=Integer.parseInt(buyerid);
			  HttpSession session = request.getSession();
			  int empID =  (Integer) session.getAttribute("empID"); 
			System.out.println(empID+"-----"+goodid);
			Linkbuyer  dx=new Linkbuyer();
			dx.setBUYERID(buyerids);
			dx.setGOODID(goodids);
			dx.setLINKID(linkids);
			dx.setOWNERID(ownerids);
			dx.setCREATEUSER(empID);
			 int aa;
			try {
				 aa=linkbuyerService.delLinkBuyer(dx);
				
			} catch (Exception e) {
			   aa=0;	 
			}
			
			 JsonResult aJsonResult=new JsonResult();
			    if(aa>0){
			    	aJsonResult.setState(100);
			    }else{
			    	aJsonResult.setState(200);
			    }
			 return aJsonResult;
		}
	
		
		@RequestMapping("/modLinkbuyer")
		@ResponseBody
		public Object modifyLinkbuyer(HttpServletRequest request ,Map<String,Object>map){
			   String linkid =request.getParameter("linkid");
			   Long  linkids=Long.parseLong(linkid);
			   String caigouyuan =request.getParameter("caigouyuan");
			   int caigouyuans=Integer.parseInt(caigouyuan);
			   String cpai=request.getParameter("cpai");
			   
			   String buyerid=request.getParameter("buyerid");
			   int buyerids=Integer.parseInt(buyerid);
			   
			   String ownerid=request.getParameter("ownerid");
			   int ownerids=Integer.parseInt(ownerid);
			   
			   String goodid=request.getParameter("goodid");
			   int goodids=Integer.parseInt(goodid);
			   Linkbuyer  dx=new Linkbuyer();   
			   dx.setBUYERIDS(buyerids);
			   dx.setLINKID(linkids);
			   dx.setBUYERID(caigouyuans);
			   dx.setWAREBRAND(cpai);
			   dx.setOWNERID(ownerids);
			   dx.setGOODID(goodids);
			   int jg= linkbuyerService.updateLinkBuyer(dx);
			   
			   System.out.println(jg+"更新结果");
			   JsonResult aJsonResult=new JsonResult();
			    if(jg>0){
			    	aJsonResult.setState(100);
			    }else{
			    	aJsonResult.setState(200);
			    }
			 return aJsonResult;
				 
		}
		
		
}
