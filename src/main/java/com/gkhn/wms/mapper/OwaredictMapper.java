package com.gkhn.wms.mapper;

import java.util.List;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Opwaredict;

public interface OwaredictMapper {
	    List <Opwaredict>  selectWaredictList(GclasVo a);
	    
	    int selectWaredictListCount(GclasVo a);
} 
 