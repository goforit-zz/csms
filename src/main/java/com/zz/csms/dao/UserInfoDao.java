package com.zz.csms.dao;

import com.zz.csms.module.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @author zz
 * @date 2020/3/28 23:47
 */
@Repository
public interface UserInfoDao {

    UserInfo getUserById(Integer Id);

    void insertUser(UserInfo userInfo);
}
