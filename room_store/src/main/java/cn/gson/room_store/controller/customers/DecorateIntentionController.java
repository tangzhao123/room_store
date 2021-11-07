package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.DecorateIntention;
import cn.gson.room_store.model.service.customers.DecorateIntentionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/DecorateIntention")
public class DecorateIntentionController {

    @Resource
    DecorateIntentionService service;

    @GetMapping("/selectAll")
    public List<DecorateIntention> selectAll(){
        return service.selectAll();
    }
}
