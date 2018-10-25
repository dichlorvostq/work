package com.gkhn.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.OPdeptMapper;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Odept;
import com.gkhn.wms.service.OPdeptServcie;

@Service
public class OPdeptServiceImpl  implements  OPdeptServcie{

	 @Autowired    OPdeptMapper   opdeptMapper;
	
	public List<Odept> selectDeptList(String name) {
		 GclasVo g=new GclasVo();
		 g.setName(name);
		List <Odept> list= opdeptMapper.selectDeptList(g);
		return list;
	}

	 

}
