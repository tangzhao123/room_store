package cn.gson.room_store.model.service.renthouse;

import cn.gson.room_store.model.mapper.renthouse.RentalfollowupMapper;
import cn.gson.room_store.model.mapper.renthouse.RentalhousingMapper;
import cn.gson.room_store.model.mapper.renthouse.RentalpublicpoolsMapper;
import cn.gson.room_store.model.pojos.renthouse.Rentalfollowup;
import cn.gson.room_store.model.pojos.renthouse.Rentalpublicpools;
import cn.gson.room_store.model.pojos.secondary.Customers;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
/*
 * 租房公房池Service
 * */
public class RentalpublicpoolsService {

    @Autowired
    RentalpublicpoolsMapper rentalfollowupMapper;
    @Autowired
    RentalhousingMapper rentalhousingMapper;

    //    查询租房公房池推荐客源
    public List<Customers> findRentalpublicpoolsAndCustomers(String param){
        return rentalfollowupMapper.findRentalpublicpoolsAndCustomers(param);
    }

    //    租房公房池推荐客源 完成跟进、无效
    public void updateRentalpublicpoolsKYCZ( int customersState, String secondaryNumber){
        rentalfollowupMapper.updateRentalpublicpoolsKYCZ(customersState,Integer.parseInt(secondaryNumber));
    }

    //    新增公房池推荐客源
    public void insertRentalpublicpoolsKy(Customers customers){
        rentalfollowupMapper.insertRentalpublicpoolsKy(customers);
    }

    //    移出公房池
    public void deleteRentalpublicpoolsByReppRehoNo(String reppRehoNo){
        rentalhousingMapper.updateRentalhousingRehoGfcztByNumber(2,reppRehoNo);
        rentalfollowupMapper.deleteRentalpublicpoolsByReppRehoNo(reppRehoNo);
    }

    //    移入公房池
    public void insertRentalpublicpools(Rentalpublicpools rentalpublicpools){
        rentalhousingMapper.updateRentalhousingRehoGfcztByNumber(1,rentalpublicpools.getReppRehoNo());
        rentalfollowupMapper.insertRentalpublicpools(rentalpublicpools);
    }

    public List<Rentalpublicpools> findAllRentalpublicpools(double maxm2, double minm2, double maxje, double minje, String chegshi, String xiaoqu, String[] zhuangxiu) {
        return rentalfollowupMapper.findAllRentalpublicpools(zhuangxiu,maxm2,  minm2,  maxje,  minje,  chegshi,  xiaoqu);
    }
}
