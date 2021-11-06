package cn.gson.room_store.controller.secondary;

import cn.gson.room_store.model.pojos.secondary.LookRecord;
import cn.gson.room_store.model.service.secondary.LookRecordService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<LookRecord> findAllLookRecord(){
        return lookRecordService.findAllLookRecord();
    }
}
