package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.HousingRecommended;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HousingRecommendedMapper {
    int deleteByPrimaryKey(Integer recId);

    int insert(HousingRecommended record);

    int insertSelective(HousingRecommended record);

    int batchAdd(List<HousingRecommended> list);

    HousingRecommended selectByPrimaryKey(Integer recId);

    int updateByPrimaryKeySelective(HousingRecommended record);

    int updateByPrimaryKey(HousingRecommended record);
}