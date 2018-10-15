package com.gkhn.wms.service;

import java.util.List;

import com.gkhn.wms.pojo.Linkbuyer;
import com.gkhn.wms.pojo.LinkbuyerVo;


public interface LinkbuyerService {
          List <Linkbuyer>    selectLinkbuyerList(LinkbuyerVo lk  );  
          
          int  selectBuyerCount(LinkbuyerVo lk); 
         
}
