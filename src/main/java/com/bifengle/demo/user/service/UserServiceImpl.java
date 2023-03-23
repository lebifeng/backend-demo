package com.bifengle.demo.user.service;

import com.bifengle.demo.user.bean.UserInfo;
import com.bifengle.demo.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userMapper;

    @Override
    public ArrayList<UserInfo> getUserList() {
        UserInfo user = userMapper.selectByPrimaryKey(1L);
        ArrayList<UserInfo> userList = new ArrayList<>();
        userList.add(user);
//        ArrayList<UserInfo> userList = userMapper.selectUserList();
        return userList;
    }
}
