package cn.gson.room_store.model.service.statistical;

import cn.gson.room_store.model.mapper.statistical.StatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StatisticsService {
    @Autowired
    StatisticsMapper mapper;
    public List<Object> statistics1(){
        return mapper.statistics1();
    }
    public int statistics2(){
        return mapper.statistics2();
    }
    public List<Object> statistics3(){
        return mapper.statistics3();
    }
}
