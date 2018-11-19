 package com.gkhn.wms.controller;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
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
import com.gkhn.wms.pojo.SalesDetail;
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
   LinkbuyerVo  lk=new LinkbuyerVo();
	
	@RequestMapping("/linkbuyer")
	@ResponseBody
	public Object selectLinkbuyerList(HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit) throws UnsupportedEncodingException {
 
	/*    DbcontextHolder.setDbType("OracledataSource");*/
	    
	    String  name=request .getParameter("drugname");
	     if(name!=null && name!="") {
			  name = new String(name.getBytes("iso-8859-1"),"utf-8");
		  }
	     System.out.println(name+"搜索的条件");
	     
	    int a=  limit * ( page - 1 ) ;
		 int b= limit * page;
		
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
	    /* DbcontextHolder.setDbType("OracledataSource");*/
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
		     /*DbcontextHolder.setDbType("OracledataSource");*/
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
		/*     DbcontextHolder.setDbType("OracledataSource");*/
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
		   /*  DbcontextHolder.setDbType("OracledataSource");*/
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
		/*     DbcontextHolder.setDbType("OracledataSource");*/
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
		/*     DbcontextHolder.setDbType("OracledataSource");*/
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
		
		
		
		
		
		
		  @RequestMapping("exportLinkBuyerList")
			@ResponseBody
			public JsonResult exportLinkBuyerList(HttpServletRequest request ,HttpServletResponse response,Map<String,Object>map){
				      
				System.out.println("请求进来没");
				String docsPath = request.getSession().getServletContext().getRealPath("docs");
				String fileName =  System.currentTimeMillis() + ".xlsx";//文件名
				String filePath = docsPath + "/" + fileName;
				System.out.println(docsPath);
				 
				List<Linkbuyer> aa= linkbuyerService.exportLinkBuyerList(lk);
				
				try {
					// 输出流
					OutputStream os = new FileOutputStream(filePath);
					// 工作区
					SXSSFWorkbook wb = new SXSSFWorkbook();
					SXSSFSheet sheet = (SXSSFSheet) wb.createSheet("test");
					/*for (int i = 0; i < 10; i++) {
						// 创建第一个sheet
						// 生成第一行
						XSSFRow row = sheet.createRow(i);
						// 给这一行的第一列赋值
						row.createCell(0).setCellValue("ces111");
						// 给这一行的第一列赋值
						row.createCell(1).setCellValue("cswww2222");
						System.out.println(i);
					}*/
					SXSSFRow row;
					  row = (SXSSFRow) sheet.createRow(0);
		      			 
		      			row.createCell(0).setCellValue("商品编码");
		      			row.createCell(1).setCellValue("商品名称");
		      			row.createCell(2).setCellValue("商品规格");
		      			row.createCell(3).setCellValue("厂家");
		      			row.createCell(4).setCellValue("联系人名称");
		      			row.createCell(5).setCellValue("采购员名称");
		      			row.createCell(6).setCellValue("原始厂牌");
		      			row.createCell(7).setCellValue("新增厂牌");
		      			row.createCell(8).setCellValue("货主ID");
		      			row.createCell(9).setCellValue("货主名称");
		      			row.createCell(10).setCellValue("联系人ID");
		      			row.createCell(11).setCellValue("联系人编码");
		      			row.createCell(12).setCellValue("商品ID");
		      			row.createCell(13).setCellValue("商品单位");
		      			row.createCell(14).setCellValue("商品数量");
		      			row.createCell(15).setCellValue("商品厂家名");
		      			row.createCell(16).setCellValue("创建时间");
		      		 
		      		 
					 for (int i =0;i< aa.size();i++){
						 row = (SXSSFRow) sheet.createRow(i+1);
				 
						 row.createCell(0).setCellValue(aa.get(i).getGoods());
						 row.createCell(1).setCellValue(aa.get(i).getName());
						 row.createCell(2).setCellValue(aa.get(i).getSpec());
						 row.createCell(3).setCellValue(aa.get(i).getProducer());
						 row.createCell(4).setCellValue(aa.get(i).getLinkname());
						 row.createCell(5).setCellValue(aa.get(i).getBuyername());
						 row.createCell(6).setCellValue(aa.get(i).getWAREBRAND());
						 row.createCell(7).setCellValue(aa.get(i).getNewwarebran());
						 row.createCell(8).setCellValue(aa.get(i).getOWNERID());
						 row.createCell(9).setCellValue(aa.get(i).getDeptname());
						 row.createCell(10).setCellValue(aa.get(i).getLINKID());
						 row.createCell(11).setCellValue(aa.get(i).getLinkcode());
						 row.createCell(12).setCellValue(aa.get(i).getGOODID());
						 row.createCell(13).setCellValue(aa.get(i).getMsunitno());
						 row.createCell(14).setCellValue(aa.get(i).getPacknum());
						 row.createCell(15).setCellValue(aa.get(i).getGoodsbrand());
						 row.createCell(16).setCellValue(aa.get(i).getCREATEDATE());
				        }
					// 写文件
					wb.write(os);
					// 关闭输出流
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				 
				 JsonResult aJsonResult=new JsonResult();
			 	aJsonResult.setMessage(fileName);
				 return aJsonResult; 
			}  
		
		
		
		
		
		
		
}
