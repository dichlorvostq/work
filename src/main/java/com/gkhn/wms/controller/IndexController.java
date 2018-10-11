package com.gkhn.wms.controller;


import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gkhn.wms.pojo.Meun;
import com.gkhn.wms.pojo.Pubemp;
import com.gkhn.wms.pojo.Qxml;
import com.gkhn.wms.service.IndexService;
import com.gkhn.wms.service.MeunService;
import com.gkhn.wms.service.QxmlService;
import com.gkhn.wms.util.DbcontextHolder;
import com.gkhn.wms.util.xjMD5;

@Controller
@RequestMapping("")
public class IndexController {
	
	@Autowired
	 IndexService indexService;
	@Autowired
	QxmlService qxmlService;
	
	 @Autowired
     MeunService    meunService;
	
	@RequiresPermissions("user")
 	@RequestMapping("toIndex")
	public String tologin(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
 		//通过用户id 查出所有的菜单 muen 
		HttpSession session = request.getSession();
		String name =  (String)session.getAttribute("username"); 
		//通过登录用户名查 显示用户名
		model.addAttribute("username",name);
		//获取所有菜单节点 等
		DbcontextHolder.setDbType("MysqldataSource");
		
		System.out.println("查询菜单的name?"+name);
	    List<Meun> list=	meunService.selectMeunByusernamess("老大");//这里的变量到时候根据数据库来定  （人员信息表）
	    List<Meun> soons=	meunService.selectUserSoonByusername("老大");
 		model.addAttribute("list", list);
 		model.addAttribute("slist",soons);
 		return "index";
	} 
}
	
	
		

