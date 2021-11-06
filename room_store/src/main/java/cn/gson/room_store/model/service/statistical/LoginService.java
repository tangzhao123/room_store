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
        System.err.println(phone);
        //查询次电话号码数据库是否存在
        int sum = mapper.findIDPhone(phone);
        System.out.println(sum);
        if (sum == 0) {
            System.out.println("进入一号");
            return null;
        } else {
            System.out.println("进入二号");
            return mapper.login(phone, pass);
        }
    }
}

