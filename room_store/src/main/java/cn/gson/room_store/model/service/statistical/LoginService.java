package cn.gson.room_store.model.service.statistical;

import cn.gson.room_store.model.mapper.statistical.LoginMapper;
import cn.gson.room_store.model.pojos.secondary.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    LoginMapper mapper;
    public Users login(String phone,String pass) {
        //查询次电话号码数据库是否存在
        if (findIDPhone(phone) == 0) {
            //账号不存在,返回空
            return null;
        } else {
            //账号存在,返回用户信息
            return mapper.login(phone, pass);
        }
    }
    //注册用户
    public String addUsers(Users users){
        if (findIDPhone(users.getUserPhone()) == 1) {
            //账号不存在,返回空
            return null;
        } else {
            //账号存在,新增用户
            mapper.addUsers(users);
            return "ok";
        }
    }
    //修改修改用户基本信息,名字,头像等
    public void editMessage(Users users){
        mapper.editMessage(users);
    }
    //修改密码
    public void editPassWord(Users users){
        mapper.editPassWord(users);
    }
    //查询电话号码
    public int findIDPhone(String phone){
        return mapper.findIDPhone(phone);
    }
}

