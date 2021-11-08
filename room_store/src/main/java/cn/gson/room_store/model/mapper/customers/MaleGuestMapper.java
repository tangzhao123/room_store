package cn.gson.room_store.model.mapper.customers;

import cn.gson.room_store.model.pojos.customers.MaleGuest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MaleGuestMapper {
    int deleteByPrimaryKey(Integer maleId);

    int insert(MaleGuest record);

    int insertSelective(MaleGuest record);

    MaleGuest selectByPrimaryKey(Integer maleId);

    int updateByPrimaryKeySelective(MaleGuest record);

    int updateByPrimaryKey(MaleGuest record);
}