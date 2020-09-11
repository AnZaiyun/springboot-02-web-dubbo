package com.anzaiyun.api.services;

import com.anzaiyun.api.dao.Users;

public interface UserService {

    public Users FindById(int id);

    public Users FindByName(String vc_name);

    public Users[] FindUser();

    public Boolean InsertUser(Users userDao);

    public Boolean UpdateUser(Users userDao);

}
