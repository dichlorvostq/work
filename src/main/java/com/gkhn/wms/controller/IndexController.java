package com.gkhn.wms.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Meun;
import com.gkhn.wms.service.DeptService;
import com.gkhn.wms.service.IndexService;
import com.gkhn.wms.service.MeunService;
 

@Controller
@RequestMapping("")
public class IndexController {
	
	@Autowired
	 IndexService indexService;
	 
	
	 @Autowired
     MeunService    meunService;
	
	 @Autowired  DeptService   deptService;
	 
	 
	@RequiresPermissions("user")
 	@RequestMapping("toIndex")
	public String tologin(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
	/*	DbcontextHolder.setDbType("OracledataSource");*/
 		//通过用户id 查出所有的菜单 muen 
		HttpSession session = request.getSession();
		String name =  (String)session.getAttribute("username"); 
		String txname=(String)session.getAttribute("txusername");
		String bumen=(String)session.getAttribute("bumen");
		//通过部门名字去查 ownerid
		GclasVo   bbmen=new GclasVo();
		bbmen.setBumenname(bumen); 
		int ownerid=	deptService.selectDeptOwnerid(bbmen);
		session.setAttribute("ownerid", ownerid);
		
		//通过登录用户名查 显示用户名
		model.addAttribute("username",name);
		//获取所有菜单节点 等
		/*DbcontextHolder.setDbType("MysqldataSource");*/
		
		System.out.println("查询菜单的name?"+ txname);
	    List<Meun> list=	meunService.selectMeunByusernamess(txname);//这里的变量到时候根据数据库来定  （人员信息表）
	    List<Meun> soons=	meunService.selectUserSoonByusername(txname);
	    
 
	   @SuppressWarnings("unchecked")
	List <Dept>mess=(List<Dept>) request.getSession().getAttribute("ss");
	    model.addAttribute("bumen",mess);
 		model.addAttribute("list", list);
 		model.addAttribute("bumenmz",bumen);
 		model.addAttribute("slist",soons);
 		return "index";
	} 
	
	//登录时 下拉选择部门  这个请求优先于其他  请求！！
	
	@RequestMapping("xzbumen")
	@ResponseBody
	public Object  xzbumen(HttpServletRequest request, Model model){
		/* DbcontextHolder.setDbType("OracledataSource");*/
		String username=request.getParameter("bm");
		System.out.println(username+"这个是empcode");
		// 查询 code  是否存在   存在就往下走  ， 不存在提示。
		int e =indexService.selectEmpcode(username);
		if(e<1){
			model.addAttribute("codecz", "用户名错误");  
			 return "login"; 
		}else{
			/*DbcontextHolder.setDbType("MysqldataSource");*/
		 HttpSession session=request.getSession();  
		  GclasVo  s=new GclasVo();
		  s.setUsername(username);
	     int  ss=  meunService.selectUserQx(s);
		  GclasVo  a=new GclasVo();
		  a.setRoleid(ss);
		 List<Dept> list= deptService.selectDeptList(a);
		 session.setAttribute("ss",list);  
		return   list;
		}
	}
	
	
	
	@RequestMapping("/{page}") 
	public String showPage(@PathVariable String page) {
		System.out.println("页面"+page);
		return page;
	}
}
	
	
		

