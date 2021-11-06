package cn.gson.room_store.model.mapper.secondary;

import cn.gson.room_store.model.pojos.secondary.LookRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LookRecordMapper {

    //查询二手房带看记录 根据房源编号查询
    public List<LookRecord> findAllLookRecord();
}
