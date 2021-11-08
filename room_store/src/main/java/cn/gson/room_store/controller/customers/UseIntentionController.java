package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.UseIntention;
import cn.gson.room_store.model.service.customers.UseIntentionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/UseIntention")
public class UseIntentionController {

    @Resource
    UseIntentionService service;

    @GetMapping("/selectAll")
    public List<UseIntention> selectAll(){
        return service.selectAll();
    }
}
