package com.gkhn.wms.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gkhn.wms.mapper.DeptMapper;
import com.gkhn.wms.mapper.MeunMapper;
import com.gkhn.wms.pojo.Dept;
import com.gkhn.wms.pojo.GclasVo;
import com.gkhn.wms.pojo.Meun;
import com.gkhn.wms.service.DeptService;
import com.gkhn.wms.service.MeunService;

 


@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired   MeunMapper meunMapper;
	
	@Autowired   DeptMapper deptMapper;

	public List<Dept> selectDeptList(GclasVo roleid) {
		return deptMapper.selectDeptList(roleid);
	}

	public int selectDeptOwnerid(GclasVo deptname) {
		return  deptMapper.selectDeptOwnerid(deptname);
	}

	public List<Dept> selectDeptAllList() {
		 
		return deptMapper.selectDeptAllList();
	}

}
