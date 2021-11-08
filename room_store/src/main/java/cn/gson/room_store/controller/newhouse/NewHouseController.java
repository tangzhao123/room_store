package cn.gson.room_store.controller.newhouse;

import cn.gson.room_store.common.Result;
import cn.gson.room_store.model.pojos.newhouse.NewHouse;
import cn.gson.room_store.model.service.newhouse.NewHouseService;
import cn.gson.room_store.vo.newhouse.NewHouseSerachVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class NewHouseController {
    @Autowired
    NewHouseService newHouseService;
    @PostMapping("/select")
    public Result selectList(@RequestBody NewHouseSerachVo newHouseSerachVo){
        PageInfo<NewHouse> newHousePageInfo = newHouseService.selectFindAll(newHouseSerachVo);
        return Result.success(newHousePageInfo);
    }
    @PostMapping("/save")
    public Result insert(@RequestBody NewHouse newHouse){
        int insert = newHouseService.insert(newHouse);
        return Result.success(insert);
    }
    @PutMapping("/update")
    public Result update(@RequestBody NewHouse newHouse){
        int updateByAll = newHouseService.updateByAll(newHouse);
        return Result.success(updateByAll);
    }
    @GetMapping("/selectByOne/{houseId}")
    public Result selectByOne(@PathVariable("houseId") Integer houseId){
        NewHouse newHouse = newHouseService.selectByPrimaryKey(houseId);
        return Result.success(newHouse);
    }

    @GetMapping("/selectAll")
    public Result selectAll(){
        List<NewHouse> newHouses = newHouseService.selectAll();
        return Result.success(newHouses);
    }

}
