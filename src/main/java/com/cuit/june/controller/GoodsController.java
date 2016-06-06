package com.cuit.june.controller;

import com.cuit.june.pojo.TblGoods;
import com.cuit.june.services.GoodsService;
import com.cuit.june.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qhg on 16/5/31.
 */
@Controller
@RequestMapping(produces = ("text/html;charset=UTF-8"), value = "/")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping(value = "goods")
    public String goods(Model model) throws Exception {
        List<TblGoods> tblGoodsList = goodsService.getAllGoodsList();
        model.addAttribute("tblGoodsList", JsonUtil.toJson(tblGoodsList));
        return "goods";
    }

    @RequestMapping(value = "operGoods")
    public String operGoods(String oper, String pkId, String goodsNumber,
                            String goodsName, String goodsPrice, String goodsProductiondate,
                            String goodsShelflife, String goodsInventory) throws Exception {
        TblGoods tblGoods;
        if (oper.equals("add")) {
            tblGoods = new TblGoods(goodsNumber, goodsName, Double.parseDouble(goodsPrice), goodsProductiondate, goodsShelflife, Double.parseDouble(goodsInventory));
            goodsService.addGoods(tblGoods);
        } else if (oper.equals("edit")) {
            tblGoods =  new TblGoods(new BigDecimal(pkId),goodsNumber, goodsName, Double.parseDouble(goodsPrice), goodsProductiondate, goodsShelflife, Double.parseDouble(goodsInventory));
            goodsService.updateGoods(tblGoods);
        } else if (oper.equals("del")) {
            goodsService.delGoods(new BigDecimal(pkId));
        }
        return "goods";
    }


}
