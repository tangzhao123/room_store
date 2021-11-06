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
    public Users login(String name,String pass){
        return mapper.login(name, pass);
    }
}
