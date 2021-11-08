package cn.gson.room_store.controller.secondary;

import cn.gson.room_store.model.pojos.secondary.Customers;
import cn.gson.room_store.model.service.secondary.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Secondary")
public class CustomersController {

    @Autowired
    CustomersService customersService;

    //新增客源推荐
    @RequestMapping("add-customers")
    public String addCustomers(@RequestBody Customers customers){
        try {
            customersService.addCustomers(customers);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    //根据房源编号查询客源推荐
    @RequestMapping("customers-list")
    public Object findAllCustomersByPage(Integer pageNo,Integer size,String secondaryNumber){
        return customersService.findAllCustomersByPage(pageNo, size, secondaryNumber);
    }

    //修改状态(跟进)
    @RequestMapping("follow")
    public String follow(Integer customersId){

        try {
            customersService.follow(customersId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    //修改状态(无效)
    @RequestMapping("invalid")
    public String invalid(Integer customersId){

        try {
            customersService.invalid(customersId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
