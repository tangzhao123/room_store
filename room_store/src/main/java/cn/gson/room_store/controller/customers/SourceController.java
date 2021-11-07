package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.Source;
import cn.gson.room_store.model.service.customers.SourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Source")
public class SourceController {

    @Resource
    SourceService service;

    @GetMapping("/selectAll")
    public List<Source> selectAll(){
        return service.selectAll();
    }
}
