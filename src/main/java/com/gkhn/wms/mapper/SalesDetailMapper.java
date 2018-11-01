package com.gkhn.wms.mapper;

import java.util.List;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.SalesDetail;
 

public interface SalesDetailMapper {
      List <SalesDetail>  SalesDetailList(GclasVo x);
      
      int SalesDetailCount(GclasVo x);
}
