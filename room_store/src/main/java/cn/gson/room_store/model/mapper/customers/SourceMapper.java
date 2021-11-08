package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.Source;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SourceMapper {
    int deleteByPrimaryKey(Integer souId);

    int insert(Source record);

    int insertSelective(Source record);

    List<Source> selectAll();

    Source selectByPrimaryKey(Integer souId);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);
}