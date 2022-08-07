package com.horn.energy_blockchain.service.impl;

import com.horn.energy_blockchain.entity.Login;
import com.horn.energy_blockchain.entity.LoginVO;
import com.horn.energy_blockchain.entity.User;
import com.horn.energy_blockchain.mapper.UserMapper;
import com.horn.energy_blockchain.service.LoginService;
import com.horn.energy_blockchain.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(Login loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getLoginName())) {
            return new Result(400, "账号不能为空", "");
        }
        if (StringUtils.isEmpty(loginDTO.getPassWord())) {
            return new Result(400, "密码不能为空", "");
        }
        //通过登录名查询用户
        User uer = userMapper.selectByPrimaryKey(1);
        //比较密码
        if (uer != null && uer.getPassword().equals(loginDTO.getPassWord())) {
            LoginVO loginVO = new LoginVO();
            loginVO.setId(uer.getId());
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            loginVO.setToken(UUID.randomUUID().toString());
            loginVO.setUser(uer);
            return new Result(200, "", loginVO);
        }
        return new Result(401, "登录失败", "");
    }
}

