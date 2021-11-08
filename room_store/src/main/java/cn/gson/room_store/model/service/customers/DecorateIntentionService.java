package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.DecorateIntentionMapper;
import cn.gson.room_store.model.pojos.customers.DecorateIntention;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class DecorateIntentionService {

    @Resource
    DecorateIntentionMapper mapper;

    /**
     * 查询所有装修类型意向
     * @return
     */
    public List<DecorateIntention> selectAll(){
        return mapper.selectAll();
    }
}
