package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.ElMessage;
import cn.gson.room_store.model.pojos.customers.HousingRecommended;
import cn.gson.room_store.model.service.customers.HousingRecommendedService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sing")
public class HousingRecommendedController {

    @Resource
    HousingRecommendedService service;

    @PostMapping("/batchAdd")
    public ElMessage batchAdd(@RequestParam("hou") String hou){
        return service.batchAdd(hou);
    }
}
