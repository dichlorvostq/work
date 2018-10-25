package com.gkhn.wms.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gkhn.wms.pojo.Pubemp;
import com.gkhn.wms.service.IndexService;
import com.gkhn.wms.service.MeunService;
import com.gkhn.wms.util.DbcontextHolder;

@Controller
@RequestMapping("")
public class LoginController {
	
	  @Autowired   IndexService   indexService;
	  
	  @Autowired    MeunService    meunService;
	  
	  
	@RequestMapping(value="/login") 
	public String login(Model model,String username, String password,HttpServletRequest request) throws UnsupportedEncodingException {
		String a=request.getParameter("xlxname");
		//如果部门为空 返回login
		
		 if(a!=null && a!="") {
			  a = new String(a.getBytes("iso-8859-1"),"utf-8");
		  }else{
			  return "login"; 
		  }
		//如果用户名 密码为空 返回login
		if(username==null || password==null){
			 return "login"; 
		}
        Subject subject = SecurityUtils.getSubject();  
        System.out.println("程序开始的地方"+username +password);
        
        DbcontextHolder.setDbType("OracledataSource");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
        try {  
            subject.login(token);
            Session session=subject.getSession();
            Pubemp p=	indexService.LoginByEmpCode(username);
            session.setAttribute("txusername",username);  // 登录时填的 用户名 empcode
            session.setAttribute("username",p.getEmpname());//登录显示的人的名字
            session.setAttribute("bumen", a);//登录时下拉的部门
            System.out.println(p.getEmpname()+"这里是登录用户名");
            session.setAttribute("subject", subject);
            return "redirect:toIndex";
        } catch (AuthenticationException e) {  
            model.addAttribute("error", "验证失败");  
            return "login"; 
        }  
	}
}
