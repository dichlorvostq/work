package com.gkhn.wms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gkhn.wms.pojo.Meun;

public interface MeunMapper {
      List <Meun >  selectPathByusername(String userName);
      
      List<Meun>  selectUserAllByusername (@Param("username")String username);
       
      List<Meun>  selectUserSoonByusername (@Param("username")String username);
}
