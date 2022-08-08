package com.horn.energy_blockchain.controller;

import com.horn.energy_blockchain.entity.Login;
import com.horn.energy_blockchain.entity.User;
import com.horn.energy_blockchain.service.LoginService;
import com.horn.energy_blockchain.common.Result;
import com.horn.energy_blockchain.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/api/login")
    @CrossOrigin       //后端跨域
    public Result login(@RequestBody Login loginDTO){
        try {
            return loginService.login(loginDTO);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new Result(400, "登录失败", "");
        }
    }

    @PostMapping( value = "/api/register")
    @CrossOrigin
    public Result register(@RequestBody User user){
        try{

            return loginService.register(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new Result(400, "注册失败", "");
        }
    }

}
