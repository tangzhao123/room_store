package cn.gson.room_store.model.mapper.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
/*
* 租房房源Mapper
* */
public interface RentalhousingMapper {

    //查询所有租房房源
    List<Rentalhousing> findAllRentalhousing();

    //新增租房房源
    void insertRentalhousing(Rentalhousing rentalhousing);
}
