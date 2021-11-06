package cn.gson.room_store.model.mapper.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalfollowup;
import cn.gson.room_store.model.pojos.renthouse.Rentalowner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
/*
* 租房业主信息Mapper
* */
public interface RentalownerMapper {

    //查询租房业主信息
    Rentalowner findAllRentalowner(String param);

    //新增租房业主信息
    void insertRentalowner(Rentalowner rentalowner);

    //修改租房业主信息
    void updateRentalowner(Rentalowner rentalowner);
}
