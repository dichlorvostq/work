package com.gkhn.wms.service;

import java.util.List;

import com.gkhn.wms.mapper.SalesDetailMapper;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.LotnoQurey;
import com.gkhn.wms.pojo.SalesDetail;

public    interface LotnoQureyService {
      
	   List<LotnoQurey> selectLotnoQureyList(GclasVo a);
	   
	   int selectLotnoQureyCount(GclasVo a);
}
