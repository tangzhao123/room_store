package cn.gson.room_store.controller.secondary;

import cn.gson.room_store.model.pojos.secondary.Secondary;
import cn.gson.room_store.model.service.secondary.SecondaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Secondary")
public class SecondaryController {
    @Autowired
    SecondaryService secondaryService;

    //新增二手房源
    @RequestMapping("add-secondary")
    public void addSecondary(@RequestBody Secondary secondary){
        secondaryService.addSecondary(secondary);
    }
}
