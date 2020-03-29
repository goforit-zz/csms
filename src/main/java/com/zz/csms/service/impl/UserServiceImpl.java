package com.zz.csms.service.impl;

import com.alibaba.fastjson.JSON;
import com.zz.csms.dao.UserInfoDao;
import com.zz.csms.module.UserInfo;
import com.zz.csms.redis.BaseInfoRedisUtil;
import com.zz.csms.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zz
 * @date 2020/3/29 0:01
 */
@Service
public class UserServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public UserInfo getUserInfoById(Integer Id) {
        UserInfo userInfo = (UserInfo) redisTemplate.opsForValue().get(Id+"");
        if (userInfo != null) {
            return userInfo;
        }
        userInfo = userInfoMapper.getUserById(Id);
        redisTemplate.opsForValue().set(Id+"", userInfo);
        return userInfo;
    }

    @Override
    public Integer addUser(String userJson) {
        UserInfo userInfo = JSON.parseObject(userJson, UserInfo.class);
        userInfoMapper.insertUser(userInfo);
        return userInfo.getId();
    }


}
