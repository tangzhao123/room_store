package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.DemandUseKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemandUseMapper {
    int deleteBydemandId(Integer demandId);

    int deleteByPrimaryKey(DemandUseKey key);

    int insert(DemandUseKey record);

    int insertSelective(DemandUseKey record);

    int batchAdd(List<DemandUseKey> list);

    List<Integer> SelectedUseIntentionList(Integer demandId);
}