package cn.gson.room_store.controller.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalowner;
import cn.gson.room_store.model.pojos.renthouse.Rentalpublicpools;
import cn.gson.room_store.model.pojos.secondary.Customers;
import cn.gson.room_store.model.service.renthouse.RentalownerService;
import cn.gson.room_store.model.service.renthouse.RentalpublicpoolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Renthouse")

/*
 * 租房公房池Controller
 * */
public class RentalpublicpoolsController {
    @Autowired
    RentalpublicpoolsService rentalpublicpoolsService;

    //    查询租房公房池推荐客源
    @RequestMapping("findRentalpublicpoolsAndCustomers")
    public List<Customers> findRentalpublicpoolsAndCustomers(String param){
        return rentalpublicpoolsService.findRentalpublicpoolsAndCustomers(param);
    }

    //    租房公房池推荐客源 完成跟进、无效
    @RequestMapping("updateRentalpublicpoolsKYCZ")
    public void updateRentalpublicpoolsKYCZ(int customersState, String secondaryNumber){
        rentalpublicpoolsService.updateRentalpublicpoolsKYCZ(customersState,secondaryNumber);
    }

    //    新增公房池推荐客源
    @PostMapping("insertRentalpublicpoolsKy")
    public void insertRentalpublicpoolsKy(@RequestBody Customers customers){
        rentalpublicpoolsService.insertRentalpublicpoolsKy(customers);
    }

    //    移出公房池
    @RequestMapping("deleteRentalpublicpoolsByReppRehoNo")
    public void deleteRentalpublicpoolsByReppRehoNo(String reppRehoNo){
        rentalpublicpoolsService.deleteRentalpublicpoolsByReppRehoNo(reppRehoNo);
    }

    //    移入公房池
    @PostMapping("insertRentalpublicpools")
    public void insertRentalpublicpools(@RequestBody Rentalpublicpools rentalpublicpools){
        rentalpublicpoolsService.insertRentalpublicpools(rentalpublicpools);
    }
}
