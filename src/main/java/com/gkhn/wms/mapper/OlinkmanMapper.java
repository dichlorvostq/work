package com.gkhn.wms.mapper;

import java.util.List;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Olinkman;
import com.gkhn.wms.pojo.Opwaredict;

public interface OlinkmanMapper {
	    List <Olinkman>  selectLinkmanList(GclasVo a);
	    
		int  selectLinkmanListCount(GclasVo a);
} 
