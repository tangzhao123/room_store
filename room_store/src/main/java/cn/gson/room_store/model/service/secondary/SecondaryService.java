package cn.gson.room_store.model.service.secondary;

import cn.gson.room_store.model.mapper.secondary.SecondaryMapper;
import cn.gson.room_store.model.pojos.secondary.Secondary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SecondaryService {

    @Autowired
    SecondaryMapper secondaryMapper;

    //新增二手房源
    public void addSecondary(Secondary secondary){
        secondaryMapper.addSecondary(secondary);
    }

    //根据用户查询二手房源
    public Object findAllSecondaryByPage(Integer pageNo,Integer size,Secondary secondary){
        return secondaryMapper.findAllSecondary(secondary);
    }

    //根据房源编号查询
    public Secondary findAllSecondary(String secondaryNumber){
        return secondaryMapper.findAllSecondaryByUser(secondaryNumber);
    }


    //上架
    public void shelves(String secondaryNumber){
        secondaryMapper.shelves(secondaryNumber);
    }

    //下架
    public void theShelves(String secondaryNumber){
        secondaryMapper.theShelves(secondaryNumber);
    }

    public List<Secondary> selectAll(){
        return secondaryMapper.selectAll();
    }
}
