package cn.gson.room_store.model.mapper.statistical;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {
    //查询精选好房
    List<Object> statistics1();
    //查询客源人数
    int statistics2();
    //查询跟进人数
    int statistics6();
    //查询带看人数
    int statistics7();
    //查询租房房源信息
    List<Object> statistics3();
    //查询二手房数据
    List<Object> statistics4();
    //查询新房数据
    List<Object> statistics5();
    //查询七天内新房新增
    List<Object> statistics8();
    //查询七天内客源新增
    List<Object> statistics9();
    //查询七天内跟进新增
    List<Object> statistics10();
}
