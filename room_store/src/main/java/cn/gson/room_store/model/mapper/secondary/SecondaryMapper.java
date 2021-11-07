package cn.gson.room_store.model.mapper.secondary;

import cn.gson.room_store.model.pojos.secondary.Secondary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecondaryMapper {

    //新增二手房源
    public void addSecondary(Secondary secondary);

    //根据用户查询二手房源
    public List<Secondary> findAllSecondary(Secondary secondary);

    //上架
    public void shelves(String secondaryNumber);

    //下架
    public void theShelves(String secondaryNumber);
}
