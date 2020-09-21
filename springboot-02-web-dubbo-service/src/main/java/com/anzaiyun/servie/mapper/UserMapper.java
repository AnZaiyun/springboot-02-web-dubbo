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

    /**
     * 彻底删除用户数据
     * @param l_id
     * @return
     */
    public Boolean DelUserByID(Integer l_id);

    /**
     * 更新用户的状态标志位，0正常，1删除
     * @param l_id
     * @return
     */
    public Boolean UpdateUserState(Integer l_id);

}
