package com.cuit.june.controller;

import com.cuit.june.pojo.TblUserinfo;
import com.cuit.june.services.UserinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by qhg on 16/4/20.
 */
@Controller
@RequestMapping(produces = ("text/html;charset=UTF-8"), value = "/")
public class LoginController {

    @Resource
    private UserinfoService userinfoService;
    @Resource
    private HttpSession httpSession;

    /**
     * 登录
     * @param usinUsername 用户名
     * @param usinPassword 密码
     * @param view
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView dologin(String usinUsername,String usinPassword, ModelAndView view) throws Exception{
        TblUserinfo tblUserinfo = userinfoService.loginCheck(usinUsername, usinPassword);
        if (tblUserinfo != null){
            httpSession.setAttribute("user",tblUserinfo);
            view.setViewName("index");
            return view;
        }else {
            view.addObject("errorMessage","用户名或密码不正确");
            return view;
        }
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value = "logout")
    public String logout() {
        this.httpSession.removeAttribute("user");
        return "login";
    }

    /**
     * 返回首页
     * @return
     */
    @RequestMapping(value = "index")
    public String index() {
        return "index";
    }

}
