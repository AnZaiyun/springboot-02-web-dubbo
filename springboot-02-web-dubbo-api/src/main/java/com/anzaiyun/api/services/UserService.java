package com.anzaiyun.api.services;

import com.anzaiyun.api.dao.Users;

public interface UserService {

    public Users FindById(int id);

    public Users[] FindUser();

}
