package cn.gson.room_store.controller.statistical;

import cn.gson.room_store.model.pojos.secondary.Users;
import cn.gson.room_store.model.service.statistical.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    LoginService service;
    @PostMapping("/login")
    public Users login(@RequestBody  String name, String pass){
        return service.login(name,pass);
    }
}
