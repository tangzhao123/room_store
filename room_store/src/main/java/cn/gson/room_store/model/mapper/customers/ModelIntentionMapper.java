package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.ModelIntention;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModelIntentionMapper {
    int deleteByPrimaryKey(Integer modelId);

    int insert(ModelIntention record);

    int insertSelective(ModelIntention record);

    List<ModelIntention> selectAll();

    ModelIntention selectByPrimaryKey(Integer modelId);

    int updateByPrimaryKeySelective(ModelIntention record);

    int updateByPrimaryKey(ModelIntention record);
}