package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.LevelMapper;
import cn.gson.room_store.model.pojos.customers.Level;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class LevelService {

    @Resource
    LevelMapper mapper;

    /**
     * 查询所有客户等级
     * @return
     */
    public List<Level> selectAll(){
        return mapper.selectAll();
    }
}
