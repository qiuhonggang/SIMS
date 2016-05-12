package com.cuit.june.services.impl;

import com.cuit.june.mapper.TblUserinfoMapper;
import com.cuit.june.pojo.TblUserinfo;
import com.cuit.june.services.UserinfoService;
import com.cuit.june.util.ValidateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qhg on 16/4/21.
 */
@Service("UserinfoService")
public class UserinfoServiceImpl implements UserinfoService{

    @Resource
    private TblUserinfoMapper tblUserinfoMapper;

    public TblUserinfo getUserById(BigDecimal userId)throws Exception {
        return tblUserinfoMapper.selectByPrimaryKey(userId);
    }

    public TblUserinfo loginCheck(String username, String password) throws Exception{
        if (ValidateUtil.isNull(username)||ValidateUtil.isNull(password)){
            return null;
        }else {
            TblUserinfo tblUserinfo = new TblUserinfo();
            tblUserinfo.setUsinUsername(username);
            tblUserinfo.setUsinPassword(password);
            List<TblUserinfo> tblUserinfos = tblUserinfoMapper.selectByEntity(tblUserinfo);
            return ValidateUtil.isNull(tblUserinfos) ? null : tblUserinfos.get(0);
        }
    }

    public List<TblUserinfo> getAllList() throws Exception {
        return tblUserinfoMapper.getAllList();
    }

    public void addUser(String username, String password,String name,String phone) throws Exception {
        TblUserinfo tblUserinfo = new TblUserinfo(username,password,name,phone);
        tblUserinfoMapper.insert(tblUserinfo);
        System.out.println("插入用户信息成功----username:"+tblUserinfo.getUsinUsername());
    }
}
