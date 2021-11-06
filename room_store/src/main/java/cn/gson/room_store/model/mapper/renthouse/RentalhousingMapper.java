package cn.gson.room_store.model.mapper.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
/*
* 租房房源Mapper
* */
public interface RentalhousingMapper {

    //修改租房房源
    void updateRentalhousingByNumber(Rentalhousing rentalhousing);

//    修改租房房源最近跟进时间和预计下次跟进时间
    void updateRentalhousingDateByNumber(@Param("rehoGenjindate")Date rehoGenjindate , @Param("rehoXcgenjindate") Date rehoXcgenjindate , @Param("rehoNo") int rehoNo);

//    修改租房房源公房池状态
    void updateRentalhousingRehoGfcztByNumber(@Param("rehoGfczt") int rehoGfczt , @Param("rehoNumber") String rehoNumber);

    //查询所有租房房源
    List<Rentalhousing> findAllRentalhousing();

    //新增租房房源
    void insertRentalhousing(Rentalhousing rentalhousing);

//    编号查询租房房源
    List<Rentalhousing> findRentalhousingByNumber(String param);

//    修改租房房源上下架状态
    void updateRentalhousingRehoShelfByNumber(@Param("rehoShelf") int rehoShelf,@Param("rehoNumber") String rehoNumber);
}
