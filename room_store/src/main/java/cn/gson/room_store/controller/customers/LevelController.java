package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.Level;
import cn.gson.room_store.model.service.customers.LevelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Level")
public class LevelController {

    @Resource
    LevelService service;

    @GetMapping("/selectAll")
    public List<Level> selectAll(){
        return service.selectAll();
    }
}
