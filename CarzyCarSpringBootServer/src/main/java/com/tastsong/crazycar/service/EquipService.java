package com.tastsong.crazycar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tastsong.crazycar.mapper.EquipMapper;
import com.tastsong.crazycar.mapper.UserMapper;
import com.tastsong.crazycar.model.EquipModel;

@Service
public class EquipService {
    @Autowired 
    private EquipMapper equipMapper;

    @Autowired
    private UserMapper userMapper;

    public List<EquipModel> getEquipDetail(Integer uid){
        List<EquipModel> equipModels = equipMapper.getEquipList();
        for(Integer i = 0; i < equipModels.size(); i++){
            equipModels.get(i).is_has = equipMapper.isHasEquip(uid, equipModels.get(i).eid);
        }
        return equipModels;
    }

    public Integer getCurEid(Integer uid){
        return userMapper.getUserByUid(uid).eid;
    }
}
