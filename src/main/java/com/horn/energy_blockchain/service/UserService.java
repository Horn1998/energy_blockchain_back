package com.horn.energy_blockchain.service;/*
 *@Author: horn
 *@DATE: 2022/8/7 0007 23:08
 *@Description
 *@Version 1.0
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.horn.energy_blockchain.entity.QueryDTO;
import com.horn.energy_blockchain.entity.User;

import java.util.List;

public interface UserService {

    public IPage<User> selectUserPage(QueryDTO queryDTO);

    public Integer addUser(User user);

    public Integer updateUser(User user);

    public Integer deleteUser(Integer id);

    public void batchDelete(List<Integer> ids);
}
