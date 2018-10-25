package com.gkhn.wms.mapper;

import java.util.List;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Odept;

public interface OPdeptMapper {
	    List <Odept>  selectDeptList(GclasVo a);
} 
