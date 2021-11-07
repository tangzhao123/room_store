package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.UseIntention;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UseIntentionMapper {
    int deleteByPrimaryKey(Integer useId);

    int insert(UseIntention record);

    int insertSelective(UseIntention record);

    List<UseIntention> selectAll();

    UseIntention selectByPrimaryKey(Integer useId);

    int updateByPrimaryKeySelective(UseIntention record);

    int updateByPrimaryKey(UseIntention record);
}