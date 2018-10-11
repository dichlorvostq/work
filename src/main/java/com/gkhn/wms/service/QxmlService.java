package com.gkhn.wms.service;

import java.util.List;

import com.gkhn.wms.pojo.Qxml;

public interface QxmlService {
	List <Qxml>  selectQxmlByUsername (String  username);
}
