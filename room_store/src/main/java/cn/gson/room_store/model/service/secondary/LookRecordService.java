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
    public LookRecord findAllLookRecord(int lookId){
        return lookRecordMapper.findAllLookRecord(lookId);
    }

    //查询二手房带看记录 根据房源编号查询
    public List<LookRecord> allLookRecord(String keyWord,int userId){
        return lookRecordMapper.allLookRecord(keyWord,userId);
    }

    //新增带看记录
    public void addLookRecord(LookRecord lookRecord){
        lookRecordMapper.addLookRecord(lookRecord);
    }
}
