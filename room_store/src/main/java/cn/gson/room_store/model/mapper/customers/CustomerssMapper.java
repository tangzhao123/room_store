package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.Customerss;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerssMapper {
    int deleteByPrimaryKey(Integer cusId);

    int insert(Customerss record);

    int insertSelective(Customerss record);

    Customerss selectByPrimaryKey(Integer cusId);

    int updateByPrimaryKeySelective(Customerss record);

    int updateByPrimaryKey(Customerss record);

    List<Customerss> allCustomers(@Param("userId") Integer userId,@Param("cusPhone") String cusPhone,@Param("rentalId") String rentalId,@Param("souId") String souId,@Param("stateId") String stateId,@Param("levelId") String levelId);

    List<Customerss> allCustomersBymaleState();
}