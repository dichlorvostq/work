package com.gkhn.wms.service;

import java.util.List;
import java.util.Set;

import com.gkhn.wms.pojo.Clients;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Meun;
import com.gkhn.wms.pojo.Selleeruploadqty;

public interface SelleeruploadqtyService {
    List <Selleeruploadqty >  selectSelleeruploadqty(GclasVo vo);
      
      int selectSelleeruploadqtyCount(GclasVo vo);
      
      int updateSelleerups(GclasVo vo);
}
