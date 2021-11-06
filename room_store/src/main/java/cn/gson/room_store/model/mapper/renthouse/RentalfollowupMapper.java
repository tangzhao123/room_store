package cn.gson.room_store.model.mapper.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalfollowup;
import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
/*
* 租房跟进记录Mapper
* */
public interface RentalfollowupMapper {

    //查询单个跟进记录根据编号
    Rentalfollowup findRentalfollowupByNo(int param);

    //查询租房跟进记录
    List<Rentalfollowup> findAllRentalfollowup(String param);

    //新增租房跟进记录
    void insertRentalfollowup(Rentalfollowup rentalfollowup);
}
