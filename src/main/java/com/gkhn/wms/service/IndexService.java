package com.gkhn.wms.service;

import java.util.List;

import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Pubemp;

public interface IndexService {
       
	    Pubemp   LoginByEmpCode(String empcode);
	    
	    List<Pubemp> selectBuyer(GclasVo empname);
	    int     selectBuyerCount(GclasVo empname);
	    
	    int  selectEmpcode(String empcode);
	    
	    int    selectEmpID(String empcode  );
}
