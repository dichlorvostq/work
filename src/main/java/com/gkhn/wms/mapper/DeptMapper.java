package com.gkhn.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Meun;

public interface DeptMapper {
      List <Dept >  selectDeptList(GclasVo roleid);
 
        int  selectDeptOwnerid(GclasVo deptname);
      
}
