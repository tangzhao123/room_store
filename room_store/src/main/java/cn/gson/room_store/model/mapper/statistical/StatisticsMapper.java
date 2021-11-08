package cn.gson.room_store.model.mapper.statistical;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {
    List<Object> statistics1();
    int statistics2();
    List<Object> statistics3();
}
