package cn.gson.room_store.model.service.secondary;

import cn.gson.room_store.model.mapper.secondary.LookRecordMapper;
import cn.gson.room_store.model.pojos.secondary.LookRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LookRecordService {

    @Autowired
    LookRecordMapper lookRecordMapper;

    //查询二手房带看记录 根据房源编号查询
    public List<LookRecord> findAllLookRecord(int look_id){
        return lookRecordMapper.findAllLookRecord(look_id);
    }

    //查询二手房带看记录 根据房源编号查询
    public List<LookRecord> allLookRecord(){
        return lookRecordMapper.allLookRecord();
    }

    //新增带看记录
    public void addLookRecord(LookRecord lookRecord){
        lookRecordMapper.addLookRecord(lookRecord);
    }
}
