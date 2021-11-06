package cn.gson.room_store.controller.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import cn.gson.room_store.model.pojos.secondary.LookRecord;
import cn.gson.room_store.model.service.renthouse.RentalhousingService;
import cn.gson.room_store.model.service.secondary.LookRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Renthouse")

/*
 * 租房房源Controller
 * */
public class RentalhousingController {

    @Autowired
    RentalhousingService rentalhousingService;

    //查询所有租房房源
    @RequestMapping("findAllRentalhousing")
    public List<Rentalhousing> findAllRentalhousing(){
        return rentalhousingService.findAllRentalhousing();
    }

    //新增租房房源
    @PostMapping("insertRentalhousing")
    public void insertRentalhousing(@RequestBody Rentalhousing rentalhousing){
        rentalhousingService.insertRentalhousing(rentalhousing);
    }
}
