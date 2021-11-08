package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.Level;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LevelMapper {
    int deleteByPrimaryKey(Integer levelId);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(Integer levelId);

    List<Level> selectAll();

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}