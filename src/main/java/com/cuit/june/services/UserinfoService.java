package com.cuit.june.services;

import com.cuit.june.pojo.TblUserinfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qhg on 16/4/21.
 */
public interface UserinfoService {

    /**
     * 根据ID获取用户实体对象
     * @param userId
     * @return 用户实体
     * @throws Exception
     */
    TblUserinfo getUserById(BigDecimal userId) throws Exception;

    /**
     * 根据用户名密码返回实体对象
     * @param username
     * @param password
     * @return 用户实体
     * @throws Exception
     */
    TblUserinfo loginCheck(String username,String password) throws Exception;

    /**
     * 返回所有用户列表
     * @return 用户实体列表
     * @throws Exception
     */
    List<TblUserinfo> getAllList() throws Exception;

    /**
     * 添加用户信息
     * @param username 用户名
     * @param password 密码
     * @param name 姓名
     * @param phone 手机号
     * @throws Exception
     */
    void addUser(String username,String password,String name,String phone) throws Exception;
}
