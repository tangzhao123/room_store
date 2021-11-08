package cn.gson.room_store.controller.customers;

import cn.gson.room_store.model.pojos.customers.State;
import cn.gson.room_store.model.service.customers.StateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/State")
public class StateController {

    @Resource
    StateService service;

    @GetMapping("/selectAll")
    public List<State> selectAll(){
        return service.selectAll();
    }
}
