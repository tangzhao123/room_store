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
    @RequestMapping("statistics1")
    public List<Object> statistics1(){
       return service.statistics1();
    }
    @RequestMapping("statistics2")
    public int statistics2(){
        return service.statistics2();
    }
    @RequestMapping("statistics3")
    public List<Object> statistics3(){
        return service.statistics3();
    }
}
