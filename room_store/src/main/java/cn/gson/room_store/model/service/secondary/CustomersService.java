package cn.gson.room_store.model.service.secondary;

import cn.gson.room_store.model.mapper.secondary.CustomersMapper;
import cn.gson.room_store.model.pojos.secondary.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomersService {

    @Autowired
    CustomersMapper customersMapper;

    //新增客源推荐
    public void addCustomers(Customers customers){
        customersMapper.addCustomers(customers);
    }

    //根据房源编号查询客源推荐
    public Object findAllCustomersByPage(Integer pageNo,Integer size,String secondaryNumber){
        return customersMapper.findAllCustomers(secondaryNumber);
    }

    //修改状态(跟进)
    public void follow(int customersId){
        customersMapper.follow(customersId);
    }

    //修改状态(无效)
    public void invalid(int customersId){
        customersMapper.invalid(customersId);
    }
}
