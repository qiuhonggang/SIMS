package com.cuit.june.services.impl;

import com.cuit.june.mapper.TblUserinfoMapper;
import com.cuit.june.pojo.TblUserinfo;
import com.cuit.june.services.UserinfoService;
import com.cuit.june.util.MD5Util;
import com.cuit.june.util.ValidateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by qhg on 16/4/21.
 */
@Service("UserinfoService")
public class UserinfoServiceImpl implements UserinfoService {

    @Resource
    private TblUserinfoMapper tblUserinfoMapper;

    /**
     * 根据用户ID获取用户
     *
     * @param userId 用户ID
     * @return
     * @throws Exception
     */
    public TblUserinfo getUserById(BigDecimal userId) throws Exception {
        return tblUserinfoMapper.selectByPrimaryKey(userId);
    }

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    public TblUserinfo loginCheck(String username, String password) throws Exception {
        if (ValidateUtil.isNull(username) || ValidateUtil.isNull(password)) {
            return null;
        } else {
            TblUserinfo tblUserinfo = new TblUserinfo();
            tblUserinfo.setUsinUsername(username);
            tblUserinfo.setUsinPassword(MD5Util.encode(password));
            List<TblUserinfo> tblUserinfos = tblUserinfoMapper.selectByEntity(tblUserinfo);
            return ValidateUtil.isNull(tblUserinfos) ? null : tblUserinfos.get(0);
        }
    }

    /**
     * 获取所有用户列表信息
     *
     * @return 用户列表List<TblUserinfo>
     * @throws Exception
     */
    public List<TblUserinfo> getAllList() throws Exception {
        return tblUserinfoMapper.getAllList();
    }

    /**
     * 添加用户信息
     *
     * @param tblUserinfo 用户
     * @throws Exception
     */
    public void addUser(TblUserinfo tblUserinfo) throws Exception {
        if (tblUserinfo != null && !tblUserinfo.getUsinUsername().equals("") && tblUserinfo.getUsinUsername() != null) {
            tblUserinfoMapper.insert(tblUserinfo);
            System.out.println("插入用户信息成功----username:" + tblUserinfo.getUsinUsername());
        } else {
            throw new Exception("用户为空");
        }
    }

    /**
     * 更新用户信息
     *
     * @param tblUserinfo 用户
     * @throws Exception
     */
    public void updateUser(TblUserinfo tblUserinfo) throws Exception {
        System.out.println("updateUser");
        if (tblUserinfo != null && !tblUserinfo.getUsinUsername().equals("") && tblUserinfo.getUsinUsername() != null) {
            tblUserinfoMapper.updateByPrimaryKey(tblUserinfo);
            System.out.println("更新用户信息成功----username:" + tblUserinfo.getUsinUsername());
        } else {
            throw new Exception("用户为空");
        }
    }

    /**
     * 删除用户信息
     *
     * @param id
     * @throws Exception
     */
    public void delUser(BigDecimal id) throws Exception {
        System.out.println("进入删除方法" + id);
        if (id != null && !id.equals("") && getUserById(id) != null) {
            System.out.println("删除用户信息" + id);
            tblUserinfoMapper.deleteByPrimaryKey(id);
            System.out.println("删除用户信息成功----username:" + id);
        } else {
            throw new Exception("用户为空");
        }
    }
}
