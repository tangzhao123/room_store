package cn.gson.room_store.controller.statistical;

import cn.gson.room_store.model.service.statistical.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class StatisticsController {
    @Autowired
    StatisticsService service;
    //查询精选好房
    @RequestMapping("statistics1")
    public List<Object> statistics1(){
       return service.statistics1();
    }
    //查询客源人数
    @RequestMapping("statistics2")
    public int statistics2(){
        return service.statistics2();
    }
    //查询跟进人数
    @RequestMapping("statistics6")
    public int statistics6(){
        return service.statistics6();
    }
    //查询带看人数
    @RequestMapping("statistics7")
    public int statistics7(){
        return service.statistics7();
    }
    //查询租房房源信息
    @RequestMapping("statistics3")
    public List<Object> statistics3(){
        return service.statistics3();
    }
    //查询二手房数据
    @RequestMapping("statistics4")
    public List<Object> statistics4(){
        return service.statistics4();
    }
    //查询新房数据
    @RequestMapping("statistics5")
    public List<Object> statistics5(){
        return service.statistics5();
    }
    //查询七天内新房新增
    @RequestMapping("statistics8")
    public List<Object> statistics8(){
        return service.statistics8();
    }
    //查询七天内客源新增
    @RequestMapping("statistics9")
    public List<Object> statistics9(){
        return service.statistics9();
    }
    //查询七天内跟进新增
    @RequestMapping("statistics10")
    public List<Object> statistics10(){
        return service.statistics10();
    }
}
