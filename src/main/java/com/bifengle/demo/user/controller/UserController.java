package com.bifengle.demo.user.controller;

import com.bifengle.demo.common.bean.Return;
import com.bifengle.demo.user.bean.UserInfo;
import com.bifengle.demo.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getUserList")
    @ResponseBody
    public Return<ArrayList<UserInfo>> getUserList() {
        return Return.success(userService.getUserList());
    }

    ;
}
