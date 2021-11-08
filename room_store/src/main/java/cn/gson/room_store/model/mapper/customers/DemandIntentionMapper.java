package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.DemandIntention;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemandIntentionMapper {
    int deleteByPrimaryKey(Integer demandId);

    int insert(DemandIntention record);

    int insertSelective(DemandIntention record);

    DemandIntention selectByPrimaryKey(Integer demandId);

    int updateByPrimaryKeySelective(DemandIntention record);

    int updateByPrimaryKey(DemandIntention record);
}