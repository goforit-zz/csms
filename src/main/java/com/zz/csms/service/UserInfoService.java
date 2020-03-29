package com.zz.csms.service;

import com.zz.csms.module.UserInfo;
;

/**
 * @author zz
 * @date 2020/3/29 0:00
 */

public interface UserInfoService {

    UserInfo getUserInfoById(Integer Id);

    Integer addUser(String userJson);
}
