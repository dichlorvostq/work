package com.gkhn.wms.service;

import java.util.List;
import java.util.Set;

import com.gkhn.wms.pojo.Meun;

public interface MeunService {
      
	Set <String > selectMeunByusername(String username);
	
	List<Meun > selectMeunByusernamess(String username);
	
	List<Meun > selectUserSoonByusername(String username);
}
