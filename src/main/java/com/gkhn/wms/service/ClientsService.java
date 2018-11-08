package com.gkhn.wms.service;

import java.util.List;
import java.util.Set;

import com.gkhn.wms.pojo.Clients;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Meun;

public interface ClientsService {
	  List <Clients > selectClients(GclasVo roleid);
	  
	  int selectClientsCount(GclasVo vo);
}
