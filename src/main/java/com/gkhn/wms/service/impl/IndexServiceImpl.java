package com.gkhn.wms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gkhn.wms.mapper.IndexMapper;
import com.gkhn.wms.pojo.Pubemp;
import com.gkhn.wms.service.IndexService;

@Service
public class IndexServiceImpl  implements IndexService{
 
	@Autowired
     IndexMapper    indexMapper;  
 	  
	public Pubemp LoginByEmpCode(String empcode) {
		System.out.println("服务层的查询（用户名--->）"+empcode);
		Pubemp  p=  indexMapper.LoginByEmpCode(empcode);
		return p;
	}
}
