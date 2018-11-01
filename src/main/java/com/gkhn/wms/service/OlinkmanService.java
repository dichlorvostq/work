package com.gkhn.wms.service;

import java.util.List;

import com.gkhn.wms.pojo.Odept;
import com.gkhn.wms.pojo.Olinkman;
import com.gkhn.wms.pojo.Opwaredict;

public interface OlinkmanService {
	List <Olinkman>  selectLinkmanList( String name,int page,int limit);
	
	int  selectLinkmanListCount(String name);
}
