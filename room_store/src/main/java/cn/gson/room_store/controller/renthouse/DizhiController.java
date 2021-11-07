package cn.gson.room_store.controller.renthouse;

import cn.gson.room_store.model.pojos.renthouse.City;
import cn.gson.room_store.model.pojos.renthouse.County;
import cn.gson.room_store.model.pojos.renthouse.Rentalfollowup;
import cn.gson.room_store.model.pojos.renthouse.Uptown;
import cn.gson.room_store.model.service.renthouse.DizhiService;
import cn.gson.room_store.model.service.renthouse.RentalfollowupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Renthouse")

/*
 *地址Controller
 * */
public class DizhiController {

    @Autowired
    DizhiService dizhiService;

    //查询市
    @RequestMapping("findAllCity")
    public List<City> findAllCity(){
        return dizhiService.findAllCity();
    }

    //    查询区，根据市id
    @RequestMapping("findAllCountyByCountyBelong")
    public List<County> findAllCountyByCountyBelong(int countyBelong){
        return dizhiService.findAllCountyByCountyBelong(countyBelong);
    }

    //    查询小区，根据区id
    @RequestMapping("findAllUptownByUptownBelong")
    public List<Uptown> findAllUptownByUptownBelong(int uptownBelong){
        return dizhiService.findAllUptownByUptownBelong(uptownBelong);
    }
}
