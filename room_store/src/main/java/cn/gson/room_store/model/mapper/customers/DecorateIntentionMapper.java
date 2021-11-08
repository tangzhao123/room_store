package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.DecorateIntention;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DecorateIntentionMapper {
    int deleteByPrimaryKey(Integer decorId);

    int insert(DecorateIntention record);

    int insertSelective(DecorateIntention record);

    List<DecorateIntention> selectAll();

    DecorateIntention selectByPrimaryKey(Integer decorId);

    int updateByPrimaryKeySelective(DecorateIntention record);

    int updateByPrimaryKey(DecorateIntention record);
}