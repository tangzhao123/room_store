package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.StateMapper;
import cn.gson.room_store.model.pojos.customers.State;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class StateService {

    @Resource
    StateMapper mapper;

    /**
     * 查询所有客户状态
     * @return
     */
    public List<State> selectAll(){
        return mapper.selectAll();
    }
}
