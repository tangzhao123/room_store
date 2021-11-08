package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.RentalIntention;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RentalIntentionMapper {
    int deleteByPrimaryKey(Integer rentalId);

    int insert(RentalIntention record);

    int insertSelective(RentalIntention record);

    List<RentalIntention> selectAll();

    RentalIntention selectByPrimaryKey(Integer rentalId);

    int updateByPrimaryKeySelective(RentalIntention record);

    int updateByPrimaryKey(RentalIntention record);

}