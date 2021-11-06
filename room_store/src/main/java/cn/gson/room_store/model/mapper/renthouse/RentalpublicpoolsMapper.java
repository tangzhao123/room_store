package cn.gson.room_store.model.mapper.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Multifileimage;
import cn.gson.room_store.model.pojos.renthouse.Rentalpublicpools;
import cn.gson.room_store.model.pojos.secondary.Customers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
/*
* 租房公房池Mapper
* */
public interface RentalpublicpoolsMapper {

//    查询租房公房池推荐客源
    List<Customers> findRentalpublicpoolsAndCustomers(String param);

//    租房公房池推荐客源 完成跟进、无效
    void updateRentalpublicpoolsKYCZ(@Param("customersState") int customersState,@Param("secondaryNumber") String secondaryNumber);

//    新增公房池推荐客源
    void insertRentalpublicpoolsKy(Customers customers);

//    移出公房池
    void deleteRentalpublicpoolsByReppRehoNo(String reppRehoNo);

//    移入公房池
    void insertRentalpublicpools(Rentalpublicpools rentalpublicpools);
}
