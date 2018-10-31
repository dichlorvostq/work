package com.gkhn.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.QxmlMapper;
import com.gkhn.wms.pojo.Qxml;
import com.gkhn.wms.service.QxmlService;


@Service
public class QxmlServiceImpl  implements QxmlService{

	  @Autowired
	  QxmlMapper qxmlMapper;
	  
	public List<Qxml> selectQxmlByUsername(String username) {
	 
		 List <Qxml> list =qxmlMapper.selectQxmlByUsername(username);
		return list;
	}
}
