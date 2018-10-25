package com.gkhn.wms.mapper;

import java.util.List;

import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Pubemp;

public interface IndexMapper {
             Pubemp   LoginByEmpCode(String empcode);
             
             List<Pubemp> selectBuyer(GclasVo empname);
             
             int  selectEmpcode(String empcode);
} 
