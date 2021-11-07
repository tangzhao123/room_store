package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.DemandFloorKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemandFloorMapper {
    int deleteBydemandId(Integer demandId);
    int deleteByPrimaryKey(DemandFloorKey key);

    int insert(DemandFloorKey record);

    int insertSelective(DemandFloorKey record);

    int batchAdd(List<DemandFloorKey> list);

    List<Integer> SelectedFloorIntentionList(Integer demandId);
}