package cn.gson.room_store.model.service.renthouse;

import cn.gson.room_store.model.mapper.renthouse.DizhiMapper;
import cn.gson.room_store.model.mapper.renthouse.RentalfollowupMapper;
import cn.gson.room_store.model.mapper.renthouse.RentalhousingMapper;
import cn.gson.room_store.model.pojos.renthouse.City;
import cn.gson.room_store.model.pojos.renthouse.County;
import cn.gson.room_store.model.pojos.renthouse.Rentalfollowup;
import cn.gson.room_store.model.pojos.renthouse.Uptown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
/*
 * 地址Service
 * */
public class DizhiService {

    @Autowired
    DizhiMapper dizhiMapper;

    //查询市
    public List<City> findAllCity(){
        return dizhiMapper.findAllCity();
    }

//    查询区，根据市id
    public List<County> findAllCountyByCountyBelong(int countyBelong){
        return dizhiMapper.findAllCountyByCountyBelong(countyBelong);
    }

//    查询小区，根据区id
    public List<Uptown> findAllUptownByUptownBelong(int uptownBelong){
        return dizhiMapper.findAllUptownByUptownBelong(uptownBelong);
    }
}
