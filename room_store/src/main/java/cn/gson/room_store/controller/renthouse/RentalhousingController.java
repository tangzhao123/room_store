package cn.gson.room_store.controller.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import cn.gson.room_store.model.pojos.secondary.LookRecord;
import cn.gson.room_store.model.service.renthouse.RentalhousingService;
import cn.gson.room_store.model.service.secondary.LookRecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Renthouse")

/*
 * 租房房源Controller
 * */
public class RentalhousingController {

    @Autowired
    RentalhousingService rentalhousingService;


    //修改租房房源
    @PostMapping("updateRentalhousingByNumber")
    public void updateRentalhousingByNumber(@RequestBody Rentalhousing rentalhousing){
        rentalhousingService.updateRentalhousingByNumber(rentalhousing);
    }

    //    编号查询租房房源
    @RequestMapping("findRentalhousingByNumber")
    public List<Rentalhousing> findRentalhousingByNumber(String param){
        return rentalhousingService.findRentalhousingByNumber(param);
    }

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

    //    修改租房房源上下架状态
    @RequestMapping("updateRentalhousingRehoShelfByNumber")
    public void updateRentalhousingRehoShelfByNumber(int rehoShelf, String rehoNumber){
        rentalhousingService.updateRentalhousingRehoShelfByNumber(rehoShelf,rehoNumber);
    }
}
