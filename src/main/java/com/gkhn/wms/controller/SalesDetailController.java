package com.gkhn.wms.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
 
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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gkhn.wms.pojo.Clients;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Opwaredict;
import com.gkhn.wms.pojo.SalesDetail;
import com.gkhn.wms.service.ClientsService;
import com.gkhn.wms.service.DeptService;
import com.gkhn.wms.service.SalesDetailService;
import com.gkhn.wms.util.JsonResult;


@Controller
public class SalesDetailController {
	
	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");
	
	
	@Autowired SalesDetailService   salesDetailService; 
	@Autowired DeptService    deptService ;
	@Autowired ClientsService clientsService; 
     
	GclasVo x=new GclasVo();
	
	
	@RequestMapping("selectSalesDetailList")
	@ResponseBody
	public Object selectSalesDetailList(  HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit) throws UnsupportedEncodingException{
		
		
		String  changpai=request.getParameter("changpai");
		if(changpai!=null || changpai!=""){
			 x.setWarebrand(changpai);
		} 
			x.setWarebrand(null);
		
		String lianxiren=request.getParameter("lianxiren");
		if(lianxiren!=null || lianxiren!=""){
			x.setLinkcode_bth(lianxiren);
		} 
		x.setLinkcode_bth(null);
		String ksriqi=request.getParameter("ksriqi");
		if(ksriqi==null || ksriqi==""){
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式   lotno-qurey
	          ksriqi=  df.format(new Date()); 
			 
		}
		String jsriqi=request.getParameter("jsriqi");
		if(jsriqi==null || jsriqi==""){
			 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
			 jsriqi=  df.format(new Date()); 
		}
		
		String huozhu=request.getParameter("huozhu");
	     
		 if(huozhu!=null && huozhu!="") {
			 huozhu = new String(huozhu.getBytes("iso-8859-1"),"utf-8");
			 
			int  huozhus=Integer.parseInt(huozhu);
			
			  x.setOwnerid(huozhus);
		  } 
		 
		 String gongyshangid=request.getParameter("gongyshangid");
		 if(gongyshangid!=null || gongyshangid!=""){
			    x.setSupcode_bth(gongyshangid);
		} 
		    x.setSupcode_bth(null);
		 
		String shangpbianmid=request.getParameter("shangpbianmid");
		 if(shangpbianmid!=null || shangpbianmid!=""){
			   x.setGoods(shangpbianmid);
		} 
		   x.setGoods(null);
		 
		String cgyids=request.getParameter("cgyids");
		if(cgyids !=null || cgyids!=""){
			x.setEmpcode(cgyids);
		}
		 x.setEmpcode(null);
		
		System.out.println(cgyids+"登录code"+changpai+"<-厂牌"+lianxiren+"<-联系人"+ksriqi+"开始日期"+jsriqi+"结束日期"+huozhu+"货主"+gongyshangid+"供应商"+shangpbianmid+"商品编码id");
		 int a=  limit * ( page - 1 ) ;
		 int b= limit * page;
	    x.setStarcreatedate(ksriqi);
	    x.setEndcreatedate(jsriqi);
	    x.setPage(a);
	    x.setLimit(b);
		List<SalesDetail>  aa= salesDetailService.SalesDetailList(x);
		 
		int c=salesDetailService.SalesDetailCount(x);
		 JsonResult aJsonResult=new JsonResult();
		 aJsonResult.setData(aa);
		 aJsonResult.setCount(c);
		 return aJsonResult;  
		}
	
	//导出excl
	 @RequestMapping("exportSalesDetailList")
	@ResponseBody
	public JsonResult exportSalesDetailList(HttpServletRequest request ,HttpServletResponse response,Map<String,Object>map){
		      
		
		String docsPath = request.getSession().getServletContext().getRealPath("docs");
		String fileName =  System.currentTimeMillis() + ".xlsx";//文件名
		String filePath = docsPath + FILE_SEPARATOR + fileName;
		System.out.println(docsPath);
		 
		
		System.out.println(x.getBhname()+"名字是是是是什么");
		List<SalesDetail>  aa= salesDetailService.SalesDetailListALL(x);
		
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
      			 
      			row.createCell(0).setCellValue("订单号");
      			row.createCell(1).setCellValue("开单日期");
      			row.createCell(2).setCellValue("开票员");
      			row.createCell(3).setCellValue("客户代码");
      			row.createCell(4).setCellValue("客户名称");
      			row.createCell(5).setCellValue("商品代码");
      			row.createCell(6).setCellValue("市场码");
      			row.createCell(7).setCellValue("品名");
      			row.createCell(8).setCellValue("规格");
      			row.createCell(9).setCellValue("包装");
      			row.createCell(10).setCellValue("厂牌");
      			row.createCell(11).setCellValue("数量");
      			row.createCell(12).setCellValue("含税单价");
      			row.createCell(13).setCellValue("含税金额");
      			row.createCell(14).setCellValue("税率");
      			row.createCell(15).setCellValue("发票日期");
      			row.createCell(16).setCellValue("发票号");
      			row.createCell(17).setCellValue("销售部门");
      			row.createCell(18).setCellValue("订单批号");
      			row.createCell(19).setCellValue("业务类型");
      			row.createCell(20).setCellValue("商品通用名");
      			row.createCell(21).setCellValue("责任采购员ID");
      			row.createCell(22).setCellValue("责任采购员");
      			row.createCell(23).setCellValue("退货/差价原因");
      			row.createCell(24).setCellValue("原单销售时间");
      			row.createCell(25).setCellValue("当前业务员");
      			row.createCell(26).setCellValue("原订单号");
      			row.createCell(27).setCellValue("批次联系人ID");
      			row.createCell(28).setCellValue("批次联系人");
      			row.createCell(29).setCellValue("批次供应商ID");
      			row.createCell(30).setCellValue("批次供应商");
      			row.createCell(31).setCellValue("批次进仓日期");
      			row.createCell(32).setCellValue("采购员ID");
      			row.createCell(33).setCellValue("采购员");
      			row.createCell(34).setCellValue("批次进货含税单价");
      			row.createCell(35).setCellValue("批次号");
      			row.createCell(36).setCellValue("票数");
      			row.createCell(37).setCellValue("部门名称");
			 for (int i =0;i< aa.size();i++){
				 row = (SXSSFRow) sheet.createRow(i+1);
		 
				 row.createCell(0).setCellValue(aa.get(i).getBillno());
				 row.createCell(1).setCellValue(aa.get(i).getCreatedate());
				 row.createCell(2).setCellValue(aa.get(i).getCstcode());
				 row.createCell(3).setCellValue(aa.get(i).getEmpname());
				 row.createCell(4).setCellValue(aa.get(i).getDname());
				 row.createCell(5).setCellValue(aa.get(i).getGoods());
				 row.createCell(6).setCellValue(aa.get(i).getMarketno());
				 row.createCell(7).setCellValue(aa.get(i).getName());
				 row.createCell(8).setCellValue(aa.get(i).getSpec());
				 row.createCell(9).setCellValue(aa.get(i).getPacknum());
				 row.createCell(10).setCellValue(aa.get(i).getWarebrand());
				 row.createCell(11).setCellValue(aa.get(i).getBillqty());
				 row.createCell(12).setCellValue(aa.get(i).getPrc());
				 row.createCell(13).setCellValue(aa.get(i).getSumvalue());
				 row.createCell(14).setCellValue(aa.get(i).getTaxrate());
				 row.createCell(15).setCellValue(aa.get(i).getInvoicedate());
				 row.createCell(16).setCellValue(aa.get(i).getInvoiceno());
				 row.createCell(17).setCellValue(aa.get(i).getDeptname());
				 row.createCell(18).setCellValue(aa.get(i).getBthdesc());
				 row.createCell(19).setCellValue(aa.get(i).getFlowname());
				 row.createCell(20).setCellValue(aa.get(i).getGname());
				 row.createCell(21).setCellValue(aa.get(i).getWoempcode());
				 row.createCell(22).setCellValue(aa.get(i).getWoempname());
				 row.createCell(23).setCellValue(aa.get(i).getBackreasonname());
				 row.createCell(24).setCellValue(aa.get(i).getYddate());
				 row.createCell(25).setCellValue(aa.get(i).getCurempname());
				 row.createCell(26).setCellValue(aa.get(i).getOsbillno());
				 row.createCell(27).setCellValue(aa.get(i).getLinkcode_bth());
				 row.createCell(28).setCellValue(aa.get(i).getLinkname_bth());
				 row.createCell(29).setCellValue(aa.get(i).getSupcode_bth());
				 row.createCell(30).setCellValue(aa.get(i).getSupname_bth());
				 row.createCell(31).setCellValue(aa.get(i).getIndate());
				 row.createCell(32).setCellValue(aa.get(i).getBuyercode());
				 row.createCell(33).setCellValue(aa.get(i).getBuyername());
				 row.createCell(34).setCellValue(aa.get(i).getInprc());
				 row.createCell(35).setCellValue(aa.get(i).getBatchid());
				 row.createCell(36).setCellValue(aa.get(i).getInvcnt());
				 row.createCell(37).setCellValue(aa.get(i).getDdeptname());
		        }
			// 写文件
			wb.write(os);
			// 关闭输出流
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*download(filePath, response);*/
		 JsonResult aJsonResult=new JsonResult();
	 	aJsonResult.setMessage(fileName);
		 return aJsonResult; 
	} 
	 
	 
	 @RequestMapping("exdownload")
		@ResponseBody
	 public  void download(  HttpServletResponse response,HttpServletRequest request) { 
		 
		 String ycdxzdz=request.getParameter("ycdxzdz");
		 String docsPath = request.getSession().getServletContext().getRealPath("docs");
		 String filePath = docsPath + FILE_SEPARATOR + ycdxzdz;
		 
		 System.out.println(ycdxzdz+"这里是下载请求地址");
			try {
				// path是指欲下载的文件的路径。
				File file = new File(filePath);
				// 取得文件名。
				String filename = file.getName();
				// 以流的形式下载文件。
				InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				fis.close();
				// 清空response
				response.reset();
				// 设置response的Header
				response.addHeader("Content-Disposition", "attachment;filename="
						+ new String(filename.getBytes(),"ISO-8859-1"));
				response.addHeader("Content-Length", "" + file.length());
				OutputStream toClient = new BufferedOutputStream(
						response.getOutputStream());
				response.setContentType("application/vnd.ms-excel;charset=gb2312");
				toClient.write(buffer);
				toClient.flush();
				toClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	 
	 
	 @RequestMapping("ChooseDepts")  
	 @ResponseBody
	 public Object ChooseDeptss( HttpServletResponse response,HttpServletRequest request){
		 JsonResult aJsonResult=new JsonResult();
		 List<Dept> list =deptService.selectDeptAllList();
		 aJsonResult.setData(list);
		 return aJsonResult; 
		 
	 }
	 
	 
	//选择编码
			@RequestMapping("/ChooseSuppliers")
			@ResponseBody
			
		public Object ChooseSuppliers(HttpServletRequest request ,Map<String,Object>map,String id,int page,int limit) throws UnsupportedEncodingException {
			     String s="";
			     String  name=request .getParameter("name");
			     if(name!=null && name!="") {
			    	 name = new String(name.getBytes("iso-8859-1"),"utf-8");
			    	 s=name.toUpperCase();
				  }else{
					   s="医院";
				  }
			    int a=  limit * ( page - 1 ) ;
			    int b= limit * page;
			    GclasVo g=new GclasVo();
			    g.setSearch(s);
			    g.setPage(b);
			    g.setLimit(a);
			    List<Clients> list=clientsService.selectClients(g);
				int  aa= clientsService. selectClientsCount(g);
				
				 JsonResult aJsonResult=new JsonResult();
				 aJsonResult.setCount(aa);
				 aJsonResult.setData(list);
				 return aJsonResult; 
				 
			}
		
	 
	 
	 
	
}
