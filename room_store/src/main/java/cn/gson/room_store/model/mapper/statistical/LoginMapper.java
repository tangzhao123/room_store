package cn.gson.room_store.model.mapper.statistical;

import cn.gson.room_store.model.pojos.secondary.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    Users login(@Param("phone")String phone,@Param("pass")String pass);
}
