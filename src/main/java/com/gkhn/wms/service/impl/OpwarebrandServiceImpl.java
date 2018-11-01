package com.gkhn.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.OPdeptMapper;
import com.gkhn.wms.mapper.OwarebrandMapper;
import com.gkhn.wms.mapper.OwaredictMapper;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Odept;
import com.gkhn.wms.pojo.Opwaredict;
import com.gkhn.wms.pojo.Owarebrand;
import com.gkhn.wms.service.OPdeptServcie;
import com.gkhn.wms.service.OwarebrandService;
import com.gkhn.wms.service.OwaredictService;

@Service
public class OpwarebrandServiceImpl  implements  OwarebrandService{

	 @Autowired    OwarebrandMapper   owarebrandMapper;
	
	public List<Owarebrand> selectWarebrandtList(GclasVo a) {
		 List<Owarebrand> list=owarebrandMapper.selectWarebrandtList(a);
		return list;
	}

	 
	 

}
