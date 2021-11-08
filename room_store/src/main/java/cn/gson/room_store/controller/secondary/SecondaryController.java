package cn.gson.room_store.controller.secondary;

import cn.gson.room_store.model.pojos.secondary.Secondary;
import cn.gson.room_store.model.service.secondary.SecondaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/Secondary")
public class SecondaryController {

    //生成随机单号
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String newDate=sdf.format(new Date());
        String result="";
        String str = "esf";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return str+newDate+result;
    }

    @Autowired
    SecondaryService secondaryService;

    //新增二手房源
    @RequestMapping("add-secondary")
    public String addSecondary(@RequestBody Secondary secondary){
        try {
            secondary.setSecondaryNumber(getOrderIdByTime());
            secondaryService.addSecondary(secondary);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    //根据用户查询二手房源
    @RequestMapping("secondary-list")
    public Object findAllSecondary(@RequestBody Secondary secondary){
        return secondaryService.findAllSecondaryByPage(secondary.getPageNo(), secondary.getSize(),secondary);
    }

    //上架
    @RequestMapping("shelves")
    public String
    shelves(String secondaryNumber){
        try {
            secondaryService.shelves(secondaryNumber);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    //下架
    @RequestMapping("the-shelves")
    public String theShelves(String secondaryNumber){
        try {
            secondaryService.theShelves(secondaryNumber);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @GetMapping("/selectAll")
    public List<Secondary> selectAll(@RequestParam("userId")Integer userId){
        return secondaryService.selectAll(userId);
    }
}
