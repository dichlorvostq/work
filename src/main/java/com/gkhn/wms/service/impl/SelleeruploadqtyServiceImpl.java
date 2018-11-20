package com.gkhn.wms.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.DeptMapper;
import com.gkhn.wms.mapper.MeunMapper;
import com.gkhn.wms.mapper.SelleeruploadqtyMapper;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Meun;
import com.gkhn.wms.pojo.Selleeruploadqty;
import com.gkhn.wms.service.DeptService;
import com.gkhn.wms.service.MeunService;
import com.gkhn.wms.service.SelleeruploadqtyService;

 


@Service
public class SelleeruploadqtyServiceImpl implements SelleeruploadqtyService {
	
	@Autowired  SelleeruploadqtyMapper  selleeruploadqtyMapper;
	  

	public List<Selleeruploadqty> selectSelleeruploadqty(GclasVo vo) {
/*		System.out.println(vo.getGoods()+"impl 层的goods");
*/		return selleeruploadqtyMapper.selectSelleeruploadqty(vo);
	}

	public int selectSelleeruploadqtyCount(GclasVo vo) {
		return selleeruploadqtyMapper.selectSelleeruploadqtyCount(vo);
	}

	public int updateSelleerups(GclasVo vo) {
		 
		return selleeruploadqtyMapper.updateSelleerups(vo);
	}

}
