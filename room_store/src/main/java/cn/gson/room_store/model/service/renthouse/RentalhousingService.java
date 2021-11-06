package cn.gson.room_store.model.service.renthouse;

import cn.gson.room_store.model.mapper.renthouse.MultifileimageMapper;
import cn.gson.room_store.model.mapper.renthouse.RentalhousingMapper;
import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
/*
 * 租房房源Service
 * */
public class RentalhousingService {

    @Autowired
    RentalhousingMapper rentalhousingMapper;
    @Autowired
    MultifileimageMapper multifileimageMapper;

    //修改租房房源
    public void updateRentalhousingByNumber(Rentalhousing rentalhousing){
        multifileimageMapper.deleteMultifileimageByMuimFangyuanno(rentalhousing.getRehoNumber());
        //循环新增多文件 multifileimageMapper.insertMultifileimage(multifileimage);

        rentalhousingMapper.updateRentalhousingByNumber(rentalhousing);
    }

    //查询所有租房房源
    public List<Rentalhousing> findAllRentalhousing(){
        return rentalhousingMapper.findAllRentalhousing();
    }

    //新增租房房源
    public void insertRentalhousing(Rentalhousing rentalhousing){
        //循环新增多文件 multifileimageMapper.insertMultifileimage(multifileimage);

        rentalhousingMapper.insertRentalhousing(rentalhousing);
    }

    //    编号查询租房房源
    public List<Rentalhousing> findRentalhousingByNumber(String param){
        return rentalhousingMapper.findRentalhousingByNumber(param);
    }

    //    修改租房房源上下架状态
    public void updateRentalhousingRehoShelfByNumber(int rehoShelf, String rehoNumber){
        rentalhousingMapper.updateRentalhousingRehoShelfByNumber(rehoShelf,rehoNumber);
    }
}
