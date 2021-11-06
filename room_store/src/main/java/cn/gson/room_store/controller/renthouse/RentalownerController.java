package cn.gson.room_store.controller.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalfollowup;
import cn.gson.room_store.model.pojos.renthouse.Rentalowner;
import cn.gson.room_store.model.service.renthouse.RentalfollowupService;
import cn.gson.room_store.model.service.renthouse.RentalownerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Renthouse")

/*
 * 租房业主信息Controller
 * */
public class RentalownerController {

    @Autowired
    RentalownerService rentalownerService;

    //查询租房业主信息
    @RequestMapping("findAllRentalfollowup")
    public Rentalowner findAllRentalowner(String param){
        return rentalownerService.findAllRentalowner(param);
    }

    //新增租房业主信息
    @PostMapping("insertRentalfollowup")
    public void insertRentalowner(Rentalowner rentalowner){
        rentalownerService.insertRentalowner(rentalowner);
    }

    //修改租房业主信息
    @PostMapping("updateRentalowner")
    public void updateRentalowner(Rentalowner rentalowner){
        rentalownerService.updateRentalowner(rentalowner);
    }
}
