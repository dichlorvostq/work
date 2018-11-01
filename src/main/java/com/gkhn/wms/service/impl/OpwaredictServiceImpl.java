package com.gkhn.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.OPdeptMapper;
import com.gkhn.wms.mapper.OwaredictMapper;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Odept;
import com.gkhn.wms.pojo.Opwaredict;
import com.gkhn.wms.service.OPdeptServcie;
import com.gkhn.wms.service.OwaredictService;

@Service
public class OpwaredictServiceImpl  implements  OwaredictService{

	 @Autowired    OwaredictMapper   owaredictMapper;
	
	public List<Opwaredict> selectOpwaredictList(String name,int page,int limit) {
		 GclasVo g=new GclasVo();
		 g.setBhname(name);
		 g.setPage(page);
		 g.setLimit(limit);
		List <Opwaredict> list= owaredictMapper.selectWaredictList(g);
		return list;
	}

	public int selectWaredictListCount(String name) {
		 GclasVo g=new GclasVo();
		 g.setBhname(name);
		return owaredictMapper.selectWaredictListCount(g);
	}
}
