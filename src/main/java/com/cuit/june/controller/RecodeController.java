package com.cuit.june.controller;

import com.cuit.june.pojo.TblRecords;
import com.cuit.june.services.RecodService;
import com.cuit.june.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qhg on 16/6/5.
 */
@Controller
@RequestMapping(produces = ("text/html;charset=UTF-8"), value = "/")
public class RecodeController {

    @Resource
    private RecodService recodService;

    @RequestMapping(value = "record")
    public String record(Model model) throws Exception{
        List<TblRecords> tblRecordsList = recodService.getAllRecodeList();
        model.addAttribute("tblRecordsList", JsonUtil.toJson(tblRecordsList));
        return "record";
    }

}
