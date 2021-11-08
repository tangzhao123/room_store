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
    //查询精选好房
    public List<Object> statistics1(){
        return mapper.statistics1();
    }
    //查询客源人数
    public int statistics2(){
        return mapper.statistics2();
    }
    //查询跟进人数
    public int statistics6(){
        return mapper.statistics6();
    }
    //查询带看人数
    public int statistics7(){
        return mapper.statistics7();
    }
    //查询租房房源信息
    public List<Object> statistics3(){
        return mapper.statistics3();
    }
    //查询二手房数据
    public List<Object> statistics4(){
        return mapper.statistics4();
    }
    //查询新房数据
    public List<Object> statistics5(){
        return mapper.statistics5();
    }
    //查询七天内新房新增
    public List<Object> statistics8(){
        return mapper.statistics8();
    }
    //查询七天内客源新增
    public List<Object> statistics9(){
        return mapper.statistics9();
    }
    //查询七天内跟进新增
    public List<Object> statistics10(){
        return mapper.statistics10();
    }
}
