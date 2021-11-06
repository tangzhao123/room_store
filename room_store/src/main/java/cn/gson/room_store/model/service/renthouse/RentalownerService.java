package cn.gson.room_store.model.service.renthouse;

import cn.gson.room_store.model.mapper.renthouse.RentalfollowupMapper;
import cn.gson.room_store.model.mapper.renthouse.RentalownerMapper;
import cn.gson.room_store.model.pojos.renthouse.Rentalfollowup;
import cn.gson.room_store.model.pojos.renthouse.Rentalowner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
/*
 * 租房业主信息Service
 * */
public class RentalownerService {

    @Autowired
    RentalownerMapper rentalownerMapper;

    //查询租房业主信息
    public List<Rentalowner> findAllRentalowner(String param){
        return rentalownerMapper.findAllRentalowner(param);
    }

    //新增租房业主信息
    public void insertRentalowner(Rentalowner rentalowner){
        rentalownerMapper.insertRentalowner(rentalowner);
    }

    //修改租房业主信息
    public void updateRentalowner(Rentalowner rentalowner){
        rentalownerMapper.updateRentalowner(rentalowner);
    }

}
