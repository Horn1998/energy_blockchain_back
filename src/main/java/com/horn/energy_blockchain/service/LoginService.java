package com.horn.energy_blockchain.service;

import com.horn.energy_blockchain.entity.Login;
import com.horn.energy_blockchain.common.Result;
import com.horn.energy_blockchain.entity.User;

public interface LoginService {
    public Result login(Login loginDTO);

    public Result register(User user);

}
