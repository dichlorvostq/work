package com.gkhn.wms.service;

import java.util.List;

import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Opwaredict;

public interface OwaredictService {
	List <Opwaredict>  selectOpwaredictList(  String name,int page,int limit);
	
	int selectWaredictListCount(String name);
}
