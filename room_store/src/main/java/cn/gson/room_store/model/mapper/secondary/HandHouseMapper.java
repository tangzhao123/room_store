package cn.gson.room_store.model.mapper.secondary;

import cn.gson.room_store.model.pojos.secondary.HandHouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HandHouseMapper {

    //新增公房池
    public void addHandHouse(HandHouse handHouse);

    //移入公房池
    public void move(String secondaryNumber);

    //移出公房池
    public void remove(String secondaryNumber);

    //根据房源编号删除公房池信息
    public void delHandHouse(String secondaryNumber);

    //查询公房池所有的信息
    public List<HandHouse> findAllHandHouse(String name);
}
