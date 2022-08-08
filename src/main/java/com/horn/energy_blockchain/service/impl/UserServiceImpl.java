package com.horn.energy_blockchain.service.impl;/*
 *@Author: horn
 *@DATE: 2022/8/7 0007 23:08
 *@Description
 *@Version 1.0
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.horn.energy_blockchain.common.Result;
import com.horn.energy_blockchain.entity.QueryDTO;
import com.horn.energy_blockchain.entity.User;
import com.horn.energy_blockchain.mapper.UserMapper;
import com.horn.energy_blockchain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询
     **/
    @Override
    public IPage<User> selectUserPage(QueryDTO queryDTO) {
        Page<User> page=new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());

        return userMapper.selectUserPage(page,queryDTO.getKeyword());
    }

    @Override
    public Integer addUser(User user) {
        try{
            if (StringUtils.isEmpty(user.getLoginName())) {
               return 0;
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                return 0;
            }
            userMapper.insert(user);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public Integer updateUser(User user) {
        try {
            return userMapper.updateByPrimaryKey(user);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        try{
            for(Integer id:ids){
                userMapper.deleteByPrimaryKey(id);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
