package cn.gson.room_store.controller.secondary;


import cn.gson.room_store.model.pojos.secondary.HandHouse;
import cn.gson.room_store.model.service.secondary.HandHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/Secondary")
public class HandHouseController {

    @Autowired
    HandHouseService handHouseService;

    //生成随机单号
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String newDate=sdf.format(new Date());
        String result="";
        String str = "gfc";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return str+newDate+result;
    }

    //新增公房池
    @RequestMapping("add-handHouse")
    public String addHandHouse(@RequestBody HandHouse handHouse){
        try {
            handHouse.setHouseNumber(getOrderIdByTime());
            handHouseService.addHandHouse(handHouse);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    //移出公房池
    @RequestMapping("remove-handHouse")
    public String removeHouse(String secondaryNumber){
        try {
            handHouseService.delHandHouse(secondaryNumber);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    //查询公房池所有的信息
    @RequestMapping("handHouse-list")
    public Object findAllHandHouseByPage(Integer pageNo,Integer size,String name){
        return handHouseService.findAllHandHouseByPage(pageNo, size,name);
    }
}
