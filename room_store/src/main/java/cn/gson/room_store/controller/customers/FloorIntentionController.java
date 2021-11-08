package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.FloorIntention;
import cn.gson.room_store.model.service.customers.FloorIntentionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/FloorIntention")
public class FloorIntentionController {

    @Resource
    FloorIntentionService service;

    @GetMapping("/selectAll")
    public List<FloorIntention> selectAll(){
        return service.selectAll();
    }
}
