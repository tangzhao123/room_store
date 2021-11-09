package cn.gson.room_store.model.service.statistical;

import cn.gson.room_store.model.mapper.statistical.LoginMapper;
import cn.gson.room_store.model.pojos.secondary.Users;
import cn.gson.room_store.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional
public class LoginService {
    @Autowired
    LoginMapper mapper;
    public Users login(String phone,String pass) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(pass);
        //查询次电话号码数据库是否存在
        if (findIDPhone(phone) == 0) {
            //账号不存在,返回空
            return null;
        } else {
                Users users1 =  mapper.login(phone);
            System.out.println(users1);
                if(users1 != null){
                    if(MD5.validPassword(pass,users1.getUserPass())){
                        return users1;
                    }else{
                        return null;
                    }
                }else{
                    return null;
                }//            String md5 = MD5.validPassword(pass.getUserPass(),Users.);
//            users.setUserPass(md5);
            //账号存在,返回用户信息
//            return mapper.login(phone, pass);
        }
    }
    //注册用户
    public String addUsers(Users users) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String md5 = MD5.getEncryptedPwd(users.getUserPass());
        users.setUserPass(md5);
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
    public String editPassWord(Users users) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String md5 = MD5.getEncryptedPwd(users.getUserPass());
        users.setUserPass(md5);
        int sum= mapper.edits(users);
        if (sum == 0){
            return null;
        }else{
            mapper.editPassWord(users);
            return "ok";
        }

    }
    //查询电话号码
    public int findIDPhone(String phone){
        return mapper.findIDPhone(phone);
    }
}

