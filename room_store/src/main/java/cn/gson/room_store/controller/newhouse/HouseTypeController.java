package cn.gson.room_store.controller.newhouse;

import cn.gson.room_store.common.Result;
import cn.gson.room_store.model.pojos.newhouse.HouseType;
import cn.gson.room_store.model.service.newhouse.HouseTypeService;
import cn.gson.room_store.vo.newhouse.HouseTypeSearchVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type")
public class HouseTypeController {
    @Autowired
    HouseTypeService houseTypeService;
    @PostMapping("/insert")
    public Result insert(@RequestBody HouseType houseType){
        int insert = houseTypeService.insert(houseType);
        return Result.success(insert);
    }
    @PutMapping("/update")
    public Result update(@RequestBody HouseType houseType){
        int update = houseTypeService.updateByAll(houseType);
        return Result.success(update);
    }
    @PostMapping("/select")
    public Result select(@RequestBody HouseTypeSearchVo houseTypeSearchVo){
        PageInfo<HouseType> houseTypePageInfo = houseTypeService.selectByAll(houseTypeSearchVo);
        return Result.success(houseTypePageInfo);
    }
}
