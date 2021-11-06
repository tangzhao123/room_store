package cn.gson.room_store.model.mapper.renthouse;

import cn.gson.room_store.model.pojos.renthouse.Rentalhousing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RentalhousingMapper {
    List<Rentalhousing> findAllRentalhousing();
}
