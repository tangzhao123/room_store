package cn.gson.room_store.controller.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalfollowup;
import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import cn.gson.room_store.model.service.renthouse.RentalfollowupService;
import cn.gson.room_store.model.service.renthouse.RentalhousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Renthouse")

/*
 * 租房跟进记录Controller
 * */
public class RentalfollowupController {

    @Autowired
    RentalfollowupService rentalfollowupService;


    //查询单个跟进记录根据编号
    @RequestMapping("findRentalfollowupByNo")
    public Rentalfollowup findRentalfollowupByNo(int param){
        return rentalfollowupService.findRentalfollowupByNo(param);
    }

    //查询租房跟进记录
    @RequestMapping("findAllRentalfollowup")
    public List<Rentalfollowup> findAllRentalfollowup(String param){
        return rentalfollowupService.findAllRentalfollowup(param);
    }

    //新增租房跟进记录
    @PostMapping("insertRentalfollowup")
    public void insertRentalfollowup(@RequestBody Rentalfollowup rentalfollowup){
        rentalfollowupService.insertRentalfollowup(rentalfollowup);
    }
}
