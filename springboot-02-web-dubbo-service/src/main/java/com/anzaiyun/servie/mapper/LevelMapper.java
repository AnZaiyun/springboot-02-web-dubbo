package com.anzaiyun.servie.mapper;

import com.anzaiyun.api.dao.Level;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelMapper {

    public Level[] FindLevels();

    public Level FindLevelById(Integer l_id);

    public Level FindLevelByName(String vc_name);

    public Boolean AddLevel(Level level);

    public Boolean UpdateLevel(Level level);

    public Boolean DelLevel(Level level);
}
