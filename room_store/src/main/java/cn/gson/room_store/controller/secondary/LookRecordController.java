package cn.gson.room_store.controller.secondary;

import cn.gson.room_store.model.pojos.secondary.LookRecord;
import cn.gson.room_store.model.service.secondary.LookRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Secondary")
public class LookRecordController {

    @Autowired
    LookRecordService lookRecordService;

    //查询二手房带看记录 根据房源编号查询
    @RequestMapping("look-record-list")
    public List<LookRecord> findAllLookRecord(int look_id){
        return lookRecordService.findAllLookRecord(look_id);
    }

    //查询二手房带看记录
    @RequestMapping("record-list")
    public List<LookRecord> allLookRecord(){
        return lookRecordService.allLookRecord();
    }


    @RequestMapping("add-look-record")
    public String addLookRecord(@RequestBody LookRecord lookRecord){
        try {
            lookRecordService.addLookRecord(lookRecord);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
