package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.FloorIntention;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FloorIntentionMapper {
    int deleteByPrimaryKey(Integer floorId);

    int insert(FloorIntention record);

    int insertSelective(FloorIntention record);

    List<FloorIntention> selectAll();

    FloorIntention selectByPrimaryKey(Integer floorId);

    int updateByPrimaryKeySelective(FloorIntention record);

    int updateByPrimaryKey(FloorIntention record);
}