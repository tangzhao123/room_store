package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.ModelIntention;
import cn.gson.room_store.model.service.customers.ModelIntentionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ModelIntention")
public class ModelIntentionController {

    @Resource
    ModelIntentionService service;

    @GetMapping("/selectAll")
    public List<ModelIntention> selectAll(){
        return service.selectAll();
    }
}
