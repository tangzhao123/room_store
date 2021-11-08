package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.Customerss;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerssMapper {
    int deleteByPrimaryKey(Integer cusId);

    int insert(Customerss record);

    int insertSelective(Customerss record);

    Customerss selectByPrimaryKey(Integer cusId);

    int updateByPrimaryKeySelective(Customerss record);

    int updateByPrimaryKey(Customerss record);

    List<Customerss> allCustomers(Integer userId);

    List<Customerss> allCustomersBymaleState();
}