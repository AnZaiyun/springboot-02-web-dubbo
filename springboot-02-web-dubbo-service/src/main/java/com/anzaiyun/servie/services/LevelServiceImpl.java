package com.anzaiyun.servie.services;

import com.anzaiyun.api.dao.Level;
import com.anzaiyun.api.services.LevelService;
import com.anzaiyun.servie.mapper.LevelMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    LevelMapper levelMapper;

    @Override
    public Level[] FindLevels() {
        Level[] levels = levelMapper.FindLevels();
        return levels;
    }

    @Override
    public Level FindLevelById(Integer l_id) {
        Level level = levelMapper.FindLevelById(l_id);
        return level;
    }

    @Override
    public Level FindLevelByName(String vc_name) {
        Level level = levelMapper.FindLevelByName(vc_name);
        return level;
    }

    @Override
    public Boolean AddLevel(Level level) {
        levelMapper.AddLevel(level);
        return true;
    }

    @Override
    public Boolean UpdateLevel(Level level) {
        levelMapper.UpdateLevel(level);
        return true;
    }

    @Override
    public Boolean DelLevel(Level level) {
        levelMapper.DelLevel(level);
        return true;
    }
}
