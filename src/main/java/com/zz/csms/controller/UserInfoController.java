package com.zz.csms.controller;

import com.zz.csms.common.CsmsResponse;
import com.zz.csms.module.UserInfo;
import com.zz.csms.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zz
 * @date 2020/3/29 0:02
 */
@RestController
@RequestMapping("/csms/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/getuserbyid")
    public UserInfo getUserById(Integer id) {
        return userInfoService.getUserInfoById(id);
    }

    @RequestMapping("/adduser")
    public Integer addUser(String userJson) {
        return userInfoService.addUser(userJson);
    }
}
