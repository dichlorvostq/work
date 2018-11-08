package com.gkhn.wms.service.impl;

 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.ClientsMapper;
import com.gkhn.wms.mapper.DeptMapper;
import com.gkhn.wms.mapper.MeunMapper;
import com.gkhn.wms.pojo.Clients;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.service.ClientsService;
import com.gkhn.wms.service.DeptService;


@Service
public class ClientsServiceImpl implements ClientsService {
	
	@Autowired    ClientsMapper  clientsMapper;

	public List<Clients> selectClients(GclasVo roleid) {
		List <Clients> list=clientsMapper.selectClients(roleid);
		return list;
	}

	public int selectClientsCount(GclasVo vo) {
		 
		return clientsMapper.selectClientsCount(vo);
	}
	
	 

	 

}
