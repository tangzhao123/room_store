package cn.gson.room_store.controller.statistical;

import cn.gson.room_store.model.pojos.secondary.Users;
import cn.gson.room_store.model.service.statistical.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class LoginController {
    @Autowired
    LoginService service;
    @PostMapping("/login")
    public Users login(@RequestBody Map<String,String> map){
        String phone = map.get("phone");
        String pass = map.get("pass");
            return service.login(phone,pass);
    }
}
