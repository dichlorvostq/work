package com.gkhn.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.LinkbuyerMapper;
import com.gkhn.wms.pojo.Linkbuyer;
import com.gkhn.wms.pojo.LinkbuyerVo;
import com.gkhn.wms.service.LinkbuyerService;


@Service
public class LinkbuyerServiceImpl  implements LinkbuyerService{

	@Autowired   LinkbuyerMapper   linkbuyerMapper;
 	
	
	public List<Linkbuyer> selectLinkbuyerList(LinkbuyerVo lk) {
		
		return linkbuyerMapper.selectLinkbuyerList(lk);   
	}

	public int selectBuyerCount(LinkbuyerVo lk) {
	   
		return linkbuyerMapper.selectBuyerCount(lk);
	}

	public int addLinkBuyer(Linkbuyer dx) {
		
		return linkbuyerMapper.addLinkBuyer(dx);
	}

	public int delLinkBuyer(Linkbuyer dx) {
		 return linkbuyerMapper.delLinkBuyer(dx);
	}

	public int updateLinkBuyer(Linkbuyer dx) {
		 
		return linkbuyerMapper.updateLinkBuyer(dx);
	}
	
	
}
