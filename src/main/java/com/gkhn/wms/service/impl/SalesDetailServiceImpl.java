package com.gkhn.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.SalesDetailMapper;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.SalesDetail;
import com.gkhn.wms.service.SalesDetailService;


@Service
public class SalesDetailServiceImpl implements SalesDetailService {
	
	@Autowired SalesDetailMapper  salesDetailMapper; 

	public List<SalesDetail> SalesDetailList(GclasVo x) {
	    	
		return salesDetailMapper.SalesDetailList(x);
	}

	public int SalesDetailCount(GclasVo x) {
		 
		return salesDetailMapper.SalesDetailCount(x);
	}

}
