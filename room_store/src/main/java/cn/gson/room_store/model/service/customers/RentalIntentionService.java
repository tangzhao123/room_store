package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.RentalIntentionMapper;
import cn.gson.room_store.model.pojos.customers.RentalIntention;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class RentalIntentionService {

    @Resource
    RentalIntentionMapper mapper;

    /**
     * 查询所有客户意向
     * @return
     */
    public List<RentalIntention> selectAll(){
        return mapper.selectAll();
    }
}
