package com.horn.energy_blockchain.controller;

import com.horn.energy_blockchain.entity.Login;
import com.horn.energy_blockchain.service.LoginService;
import com.horn.energy_blockchain.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/api/login")
    @CrossOrigin       //后端跨域
    public Result login(@RequestBody Login loginDTO){
        try {
            return loginService.login(loginDTO);
        }catch (Exception e){
            System.out.println("执行失败");
            return new Result(400, "登录失败", "");
        }
    }
}
