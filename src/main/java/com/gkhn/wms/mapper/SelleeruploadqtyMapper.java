package com.gkhn.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gkhn.wms.pojo.Clients;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Meun;
import com.gkhn.wms.pojo.Selleeruploadqty;

public interface SelleeruploadqtyMapper {
     List <Selleeruploadqty >  selectSelleeruploadqty(GclasVo vo);
      
      int selectSelleeruploadqtyCount(GclasVo vo);
      
      int updateSelleerups(GclasVo vo);
 
}
