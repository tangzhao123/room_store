package cn.gson.room_store.model.service.renthouse;

import cn.gson.room_store.model.mapper.renthouse.RentalfollowupMapper;
import cn.gson.room_store.model.mapper.renthouse.RentalhousingMapper;
import cn.gson.room_store.model.pojos.renthouse.Rentalfollowup;
import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
/*
 * 租房跟进记录Service
 * */
public class RentalfollowupService {

    @Autowired
    RentalfollowupMapper rentalfollowupMapper;

    //查询租房跟进记录
    public List<Rentalfollowup> findAllRentalfollowup(String param){
        return rentalfollowupMapper.findAllRentalfollowup(param);
    }

    //新增租房跟进记录
    public void insertRentalfollowup(Rentalfollowup rentalfollowup){
        rentalfollowupMapper.insertRentalfollowup(rentalfollowup);
    }

}
