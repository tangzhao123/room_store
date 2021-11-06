package cn.gson.room_store.model.mapper.secondary;

import cn.gson.room_store.model.pojos.secondary.Secondary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecondaryMapper {

    //新增二手房源
    public void addSecondary(Secondary secondary);
}
