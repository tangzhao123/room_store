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
    @RequestMapping("addusers")
    public String addUsers(@RequestBody Users users){
        try {
            return service.addUsers(users);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @RequestMapping("editmassage")
    public String editMessage(@RequestBody Users users){
        try {
            service.editMessage(users);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @RequestMapping("edituserpass")
    public String eaitPassWord(@RequestBody Users users){
        try {
            service.editPassWord(users);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
