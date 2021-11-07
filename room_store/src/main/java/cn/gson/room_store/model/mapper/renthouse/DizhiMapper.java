package cn.gson.room_store.model.mapper.renthouse;

import cn.gson.room_store.model.pojos.renthouse.City;
import cn.gson.room_store.model.pojos.renthouse.County;
import cn.gson.room_store.model.pojos.renthouse.Multifileimage;
import cn.gson.room_store.model.pojos.renthouse.Uptown;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
/*
* 地址Mapper
* */
public interface DizhiMapper {
//    查询市
    List<City> findAllCity();

//    查询区，根据市id
    List<County> findAllCountyByCountyBelong(int countyBelong);

//    查询小区，根据区id
    List<Uptown> findAllUptownByUptownBelong(int uptownBelong);
}
