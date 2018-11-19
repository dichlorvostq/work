package com.gkhn.wms.mapper;

import java.util.List;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.LotnoQurey;
import com.gkhn.wms.pojo.SalesDetail;
 

public interface LotnoQureyMapper {
        List<LotnoQurey> selectLotnoQureyList(GclasVo a);
        
        int selectLotnoQureyCount(GclasVo a);
}
