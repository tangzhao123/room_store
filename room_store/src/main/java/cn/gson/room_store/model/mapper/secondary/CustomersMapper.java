package cn.gson.room_store.model.mapper.secondary;

import cn.gson.room_store.model.pojos.secondary.Customers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomersMapper {

    //新增客源推荐
    public void addCustomers(Customers customers);

    //根据房源编号查询客源推荐
    public List<Customers> findAllCustomers(String secondaryNumber);

    //修改状态(跟进)
    public void follow(int customersId);

    //修改状态(无效)
    public void invalid(int customersId);
}
