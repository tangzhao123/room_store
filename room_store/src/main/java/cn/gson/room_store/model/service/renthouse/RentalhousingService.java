package cn.gson.room_store.model.service.renthouse;

import cn.gson.room_store.model.mapper.renthouse.RentalhousingMapper;
import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
/*
 * 租房房源Service
 * */
public class RentalhousingService {

    @Autowired
    RentalhousingMapper rentalhousingMapper;

    //查询所有租房房源
    public List<Rentalhousing> findAllRentalhousing(){
        return rentalhousingMapper.findAllRentalhousing();
    }

    //新增租房房源
    public void insertRentalhousing(Rentalhousing rentalhousing){
        rentalhousingMapper.insertRentalhousing(rentalhousing);
    }
}
