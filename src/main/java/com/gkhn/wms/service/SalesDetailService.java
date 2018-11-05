package com.gkhn.wms.service;

import java.util.List;

import com.gkhn.wms.mapper.SalesDetailMapper;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.SalesDetail;

public    interface SalesDetailService {
      
	  List <SalesDetail>  SalesDetailList(GclasVo x);
	  
	  int SalesDetailCount(GclasVo x);
	  
	  List<SalesDetail> SalesDetailListALL(GclasVo x);
}
