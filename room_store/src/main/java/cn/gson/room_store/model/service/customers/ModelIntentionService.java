package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.ModelIntentionMapper;
import cn.gson.room_store.model.pojos.customers.ModelIntention;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ModelIntentionService {

    @Resource
    ModelIntentionMapper mapper;

    /**
     * 查询所有户型意向
     * @return
     */
    public List<ModelIntention> selectAll(){
        return mapper.selectAll();
    }
}
