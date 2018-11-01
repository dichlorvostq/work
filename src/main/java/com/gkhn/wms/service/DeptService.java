package com.gkhn.wms.service;

import java.util.List;
import java.util.Set;

import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Meun;

public interface DeptService {
	  List <Dept >  selectDeptList(GclasVo roleid);
	  
	  int  selectDeptOwnerid(GclasVo deptname);
}
