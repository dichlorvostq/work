package com.gkhn.wms.mapper;

import java.util.List;

import com.gkhn.wms.pojo.Linkbuyer;
import com.gkhn.wms.pojo.LinkbuyerVo;

public interface LinkbuyerMapper {
	    List <Linkbuyer>  selectLinkbuyerList(LinkbuyerVo lk);
	    
	    int  selectBuyerCount(LinkbuyerVo lk); 
	    
	    int addLinkBuyer(Linkbuyer dx);
	    
} 
