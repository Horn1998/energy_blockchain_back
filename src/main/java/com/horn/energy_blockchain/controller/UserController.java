package com.horn.energy_blockchain.controller;/*
 *@Author: horn
 *@DATE: 2022/8/7 0007 23:06
 *@Description
 *@Version 1.0
 */

import com.horn.energy_blockchain.common.Result;
import com.horn.energy_blockchain.entity.QueryDTO;
import com.horn.energy_blockchain.entity.User;
import com.horn.energy_blockchain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @PostMapping("/api/user/list")
    public Result userList(@RequestBody QueryDTO queryDTO){
        try{
            return new Result(200,"",userService.selectUserPage(queryDTO));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new Result(400, e.getMessage(), "");
        }
    }

    /**
     * 添加
     * @param user
     * @return
     */
    @PostMapping("/api/user/add")
    public Result addUser(@RequestBody User user){
        try {
            return new Result(200,"",userService.addUser(user));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(400, e.getMessage(), "");
        }
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @PostMapping("/api/user/update")
    public Result updateUser(@RequestBody User user){
        try {
            return new Result(200,"",userService.updateUser(user));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400, e.getMessage(), "");
        }
    }

    /**
     * 删除
     * @param user
     * @return
     */
    @PostMapping("/api/user/delete")
    public Result deleteUser(@RequestBody User user){
        try {
            Integer id = user.getId();
            return new Result(200,"",userService.deleteUser(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400, e.getMessage(), "");
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/api/user/deleteBatch")
    public Result batchDeleteUser(@RequestBody List<Integer> ids){
        try {
            System.out.println("delete/batch");
            for(int id:ids) System.out.println(id);
            userService.batchDelete(ids);
            return new Result(200,"","");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Result(400, e.getMessage(), "");
        }
    }
}
