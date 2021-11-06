package cn.gson.room_store.controller.newhouse;

import cn.gson.room_store.common.Result;
import cn.gson.room_store.model.pojos.newhouse.SourceCollection;
import cn.gson.room_store.model.service.newhouse.SourceCollectionService;
import cn.gson.room_store.vo.newhouse.SourceCollectionSearchVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/source")
public class SourceCollectionController {
    @Autowired
    SourceCollectionService sourceCollectionService;
    @PostMapping("/select")
    public Result select(@RequestBody SourceCollectionSearchVo sourceCollectionSearchVo){
        PageInfo<SourceCollection> sourceCollectionPageInfo = sourceCollectionService.selectAll(sourceCollectionSearchVo);
        return Result.success(sourceCollectionPageInfo);
    }
    @PostMapping("/insert")
    public Result insert(@RequestBody SourceCollection sourceCollection){
        int insert = sourceCollectionService.insert(sourceCollection);
        return Result.success(insert);
    }
    @PutMapping("/update")
    public Result update(@RequestBody SourceCollection sourceCollection){
        int update = sourceCollectionService.updateByAll(sourceCollection);
        return Result.success(update);
    }
    @GetMapping("/selectOne/{sourceId}")
    public Result selectOne(@PathVariable("sourceId") Integer sourceId){
        SourceCollection sourceCollection = sourceCollectionService.selectByPrimaryKey(sourceId);
        return Result.success(sourceCollection);
    }
}
