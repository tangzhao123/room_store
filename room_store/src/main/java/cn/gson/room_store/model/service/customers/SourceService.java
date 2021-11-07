package cn.gson.room_store.model.service.customers;

import cn.gson.room_store.model.mapper.customers.SourceMapper;
import cn.gson.room_store.model.pojos.customers.Source;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SourceService {

    @Resource
    SourceMapper mapper;

    /**
     * 查询所有客户来源
     * @return
     */
    public List<Source> selectAll(){
        return mapper.selectAll();
    }
}
