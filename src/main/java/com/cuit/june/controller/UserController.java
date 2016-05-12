package com.cuit.june.controller;

import com.cuit.june.pojo.TblUserinfo;
import com.cuit.june.services.UserinfoService;
import com.cuit.june.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
     * @param view
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "userList")
    public ModelAndView userList(ModelAndView view) throws Exception {
        List<TblUserinfo> userinfoList = userinfoService.getAllList();
        view.addObject("userinfolist", JsonUtil.toJson(userinfoList));
        view.setViewName("user");
        return view;
    }

    /**
     * 添加用户
     */
    @RequestMapping(value = "addUser")
    public ModelAndView adduser(String usinUsername, String usinPassword, String usinName, String usinPhone,ModelAndView view) throws Exception {
        userinfoService.addUser(usinUsername, usinPassword, usinName, usinPhone);
        view.setViewName("redirect:user");
        return view;
    }


}
