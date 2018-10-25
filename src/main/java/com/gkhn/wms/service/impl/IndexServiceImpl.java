package com.gkhn.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gkhn.wms.mapper.IndexMapper;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Pubemp;
import com.gkhn.wms.service.IndexService;

@Service
public class IndexServiceImpl  implements IndexService{
 
	@Autowired
     IndexMapper    indexMapper;  
 	  
	public Pubemp LoginByEmpCode(String empcode) {
		Pubemp  p=  indexMapper.LoginByEmpCode(empcode);
		return p;
	}

	public List<Pubemp> selectBuyer(GclasVo empname) {
		 List<Pubemp>   pp=indexMapper.selectBuyer(empname);
		return pp;
	}

	
	public int selectEmpcode(String empcode) {
	    int a=indexMapper.selectEmpcode(empcode);
		return a;
	}
}
