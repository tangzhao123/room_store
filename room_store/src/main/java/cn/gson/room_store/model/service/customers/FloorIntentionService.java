package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.FloorIntentionMapper;
import cn.gson.room_store.model.pojos.customers.FloorIntention;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class FloorIntentionService {

    @Resource
    FloorIntentionMapper mapper;

    /**
     * 查询所有楼层意向
     * @return
     */
    public List<FloorIntention> selectAll(){
        return mapper.selectAll();
    }
}
