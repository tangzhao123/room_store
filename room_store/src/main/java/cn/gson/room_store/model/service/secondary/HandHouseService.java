package cn.gson.room_store.model.service.secondary;

import cn.gson.room_store.model.mapper.secondary.HandHouseMapper;
import cn.gson.room_store.model.pojos.secondary.HandHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HandHouseService {

    @Autowired
    HandHouseMapper handHouseMapper;

    //新增公房池
    public void addHandHouse(HandHouse handHouse){
        handHouseMapper.move(handHouse.getSecondaryNumber());
        handHouseMapper.addHandHouse(handHouse);
    }

    //删除公房池信息
    public void delHandHouse(String secondaryNumber){
        handHouseMapper.delHandHouse(secondaryNumber);
        handHouseMapper.remove(secondaryNumber);
    }

    //查询公房池所有的信息
    public Object findAllHandHouseByPage(Integer pageNo,Integer size,String name){
        return handHouseMapper.findAllHandHouse(name);
    }

}
