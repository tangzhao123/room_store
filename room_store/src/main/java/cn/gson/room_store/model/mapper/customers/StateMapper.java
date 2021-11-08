package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.State;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StateMapper {
    int deleteByPrimaryKey(Integer stateId);

    int insert(State record);

    int insertSelective(State record);

    List<State> selectAll();

    State selectByPrimaryKey(Integer stateId);

    int updateByPrimaryKeySelective(State record);

    int updateByPrimaryKey(State record);
}