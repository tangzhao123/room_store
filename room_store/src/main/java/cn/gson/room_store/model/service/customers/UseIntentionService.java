package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.UseIntentionMapper;
import cn.gson.room_store.model.pojos.customers.UseIntention;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UseIntentionService {

    @Resource
    UseIntentionMapper mapper;

    /**
     * 查询所有用途意向
     * @return
     */
    public List<UseIntention> selectAll(){
        return mapper.selectAll();
    }
}
