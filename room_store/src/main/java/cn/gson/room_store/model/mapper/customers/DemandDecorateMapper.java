package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.DemandDecorateKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DemandDecorateMapper {
    int deleteBydemandId(Integer demandId);

    int deleteByPrimaryKey(DemandDecorateKey key);

    int insert(DemandDecorateKey record);

    int insertSelective(DemandDecorateKey record);

    int batchAdd(List<DemandDecorateKey> list);

    List<Integer> SelectedDecorateIntentionList(Integer demandId);
}