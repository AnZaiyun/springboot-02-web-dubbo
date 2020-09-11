package com.anzaiyun.servie.services;

import com.alibaba.dubbo.config.annotation.Service;
import com.anzaiyun.api.dao.Users;
import com.anzaiyun.api.services.UserService;
import org.springframework.stereotype.Component;

@Service
@Component
public class UserServiceImpl implements UserService {
    @Override
    public Users FindById(int id) {
        Users user = new Users("zhang3","1732478192","1732478192@qq.ocm");
        return user;
    }

    @Override
    public Users[] FindUser() {
        Users user1 = new Users("zhang3","1732478192","1732478192@qq.ocm");
        Users user2 = new Users("li4","1376763502","1376763502@qq.ocm");
        Users[] users = {user1,user2};

        return users;
    }
}
