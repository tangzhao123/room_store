package cn.gson.room_store.model.mapper.statistical;

import cn.gson.room_store.model.pojos.secondary.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    //用户登录
    Users login(String phone);
    //查询电话号码
    int findIDPhone(String phone);
    //修改密码查看密码是否正确
    int edits(Users users);
    //注册用户
    void addUsers(Users users);
    //修改修改用户基本信息,名字,头像等
    void editMessage(Users users);
    //修改密码
    void editPassWord(Users users);
}
