package com.anzaiyun.api.services;

import com.anzaiyun.api.dao.Level;

public interface LevelService {

    public Level[] FindLevels();

    public Level FindLevelById(Integer l_id);

    public Level FindLevelByName(String vc_name);

    public Boolean AddLevel(Level level);

    public Boolean UpdateLevel(Level level);

    public Boolean DelLevel(Level level);

}
