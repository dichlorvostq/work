package com.gkhn.wms.mapper;

import java.util.List;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Opwaredict;
import com.gkhn.wms.pojo.Owarebrand;

public interface OwarebrandMapper {
	    List <Owarebrand>  selectWarebrandtList(GclasVo a);
} 
