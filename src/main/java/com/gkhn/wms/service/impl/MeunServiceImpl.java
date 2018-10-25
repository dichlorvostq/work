package com.gkhn.wms.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.MeunMapper;
import com.gkhn.wms.mapper.UserMapper;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Meun;
import com.gkhn.wms.service.MeunService;

 


@Service
public class MeunServiceImpl implements MeunService {
	
	@Autowired   MeunMapper meunMapper;

	@Autowired   UserMapper  userMapper;
	
	
	public Set<String> selectMeunByusername(  String userName) {
		System.out.println("这里是shiro servcie里面的userName---------------------------->>>"+userName);
		  List<Meun> r=meunMapper.selectPathByusername(userName);
		Set<String> s =new HashSet<String>();
		for (Meun role: r) {
			s.add(role.getMenupath());
		}
		return s;
	}


	public List<Meun> selectMeunByusernamess(String userName) {
		 List<Meun> r=meunMapper.selectUserAllByusername(userName);
		return r;
	}


	public List<Meun> selectUserSoonByusername(String username) {
		List<Meun> re=meunMapper.selectUserSoonByusername(username);
		return re;
	}


	public int selectUserQx(GclasVo username) {
		return  	userMapper.selectUserQx(username);
	}

 
	 

}
