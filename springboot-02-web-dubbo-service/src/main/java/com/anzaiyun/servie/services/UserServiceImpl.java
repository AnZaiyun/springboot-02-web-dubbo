package com.anzaiyun.servie.services;

import com.anzaiyun.api.dao.Users;
import com.anzaiyun.api.services.UserService;
import com.anzaiyun.servie.mapper.UserMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Users FindById(int id) {
        return userMapper.FindById(id);
    }

    @Override
    public Users FindByName(String vc_name) {
        return userMapper.FindByName(vc_name);
    }

    @Override
    public Users[] FindUser() {
        return userMapper.FindUser();
    }

    @Override
    public Boolean InsertUser(Users userDao) {
        if (userMapper.FindByName(userDao.getVc_name()) != null)
            return false;

        userMapper.InsertUser(userDao);
        return true;
    }

    @Override
    public Boolean UpdateUser(Users userDao) {
        if (userMapper.FindById(userDao.getL_id()) == null)
            return false;

        userMapper.UpdateUser(userDao);
        return true;
    }
}
