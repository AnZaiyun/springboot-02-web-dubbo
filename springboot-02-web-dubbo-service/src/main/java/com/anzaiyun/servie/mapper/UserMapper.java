package com.anzaiyun.servie.mapper;

import com.anzaiyun.api.dao.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    public Users FindById(int id);

    public Users FindByName(String vc_name);

    public Users[] FindUser();

    public String InsertUser(Users userDao);

    public Integer UpdateUser(Users userDao);

}
