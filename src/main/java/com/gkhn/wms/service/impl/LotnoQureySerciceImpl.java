package com.gkhn.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.LotnoQureyMapper;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.LotnoQurey;
import com.gkhn.wms.service.LotnoQureyService;

@Service
public class LotnoQureySerciceImpl  implements LotnoQureyService{
	
	@Autowired LotnoQureyMapper  lotnoQureyMapper ;

	public List<LotnoQurey> selectLotnoQureyList(GclasVo ax) {
		System.out.println(ax.getSupcode_bth()+"这里是什么？");
	  List<LotnoQurey>  list= 	lotnoQureyMapper.selectLotnoQureyList(ax);
	 return list;
	}

	public int selectLotnoQureyCount(GclasVo g) {
		
		return lotnoQureyMapper.selectLotnoQureyCount(g);
	}

	 

}
