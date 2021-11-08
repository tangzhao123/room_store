package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.DemandModelKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemandModelMapper {
    int deleteBydemandId(Integer demandId);

    int deleteByPrimaryKey(DemandModelKey key);

    int insert(DemandModelKey record);

    int insertSelective(DemandModelKey record);

    int batchAdd(List<DemandModelKey> list);

    List<Integer> SelectedModelIntentionList(Integer demandId);
}