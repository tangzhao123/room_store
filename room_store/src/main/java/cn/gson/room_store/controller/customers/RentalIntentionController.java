package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.RentalIntention;
import cn.gson.room_store.model.service.customers.RentalIntentionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/RentalIntention")
public class RentalIntentionController {

    @Resource
    RentalIntentionService service;

    @GetMapping("/selectAll")
    public List<RentalIntention> selectAll(){
        return service.selectAll();
    }
}
