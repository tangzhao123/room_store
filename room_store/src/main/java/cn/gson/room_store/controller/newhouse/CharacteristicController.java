package cn.gson.room_store.controller.newhouse;

import cn.gson.room_store.common.Result;
import cn.gson.room_store.model.pojos.newhouse.Characteristic;
import cn.gson.room_store.model.service.newhouse.CharacteristicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chara")
public class CharacteristicController {
    @Autowired
    CharacteristicService characteristicService;
    @GetMapping("/select")
    public Result select(){
        List<Characteristic> characteristics = characteristicService.selectAll();
        return Result.success(characteristics);
    }
}
