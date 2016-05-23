package com.cuit.june.controller;

import com.cuit.june.pojo.TblUserinfo;
import com.cuit.june.services.UserinfoService;
import com.cuit.june.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qhg on 16/5/8.
 */
@Controller
@RequestMapping(value = "/")
public class UserController {

    @Resource
    private UserinfoService userinfoService;


    /**
     * 返回用户列表
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "userList")
    public String userList(Model model) throws Exception {
        List<TblUserinfo> userinfoList = userinfoService.getAllList();
        model.addAttribute("userinfolist", JsonUtil.toJson(userinfoList));
        return "user";
    }

    /**
     * 添加用户
     */
    @RequestMapping(value = "operUser")
    public ModelAndView operUser(String oper, String pkId, String usinUsername, String usinPassword, String usinName, String usinPhone, ModelAndView modelAndView) throws Exception {
        TblUserinfo tblUserinfo;
        if (oper.equals("add")) {        //添加用户信息
            System.out.println("添加用户信息");
            tblUserinfo = new TblUserinfo(usinUsername, usinPassword, usinName, usinPhone);
            userinfoService.addUser(tblUserinfo);
        } else if (oper.equals("edit")) {   //编辑用户信息
            System.out.println("编辑用户信息" + pkId + "转换:" + new BigDecimal(pkId));
            tblUserinfo = new TblUserinfo(new BigDecimal(pkId), usinUsername, usinPassword, usinName, usinPhone);
            userinfoService.updateUser(tblUserinfo);
        } else if (oper.equals("del")) {    //删除用户信息
            System.out.println("删除用户信息"+pkId);
            tblUserinfo = new TblUserinfo(new BigDecimal(pkId), usinUsername, usinPassword, usinName, usinPhone);
            userinfoService.delUser(tblUserinfo);
        }
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "delUser")
    public void delUser(HttpServletRequest request){
        System.out.println("删除用户信息"+request.getParameter("pkId"));

    }


}
