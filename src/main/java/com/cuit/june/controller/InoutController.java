package com.cuit.june.controller;

import com.cuit.june.pojo.TblGoods;
import com.cuit.june.pojo.TblRecords;
import com.cuit.june.pojo.TblUserinfo;
import com.cuit.june.services.GoodsService;
import com.cuit.june.services.RecodService;
import com.cuit.june.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by qhg on 16/6/5.
 */
@Controller
@RequestMapping(produces = ("text/html;charset=UTF-8"), value = "/")
public class InoutController {

    @Resource
    GoodsService goodsService;

    @Resource
    RecodService recodService;

    @Resource
    private HttpSession httpSession;

    @RequestMapping(value = "inout")
    public String inout(Model model) throws Exception{
        List<TblGoods> tblGoodsList1 = goodsService.getAllGoodsList();
        model.addAttribute("tblGoodsList1", JsonUtil.toJson(tblGoodsList1));
        return "inout";
    }

    @RequestMapping(value = "stock",method = RequestMethod.POST)
    public String stock(String pkId,String goodsInventory,String inout,Model model) throws Exception{
        TblGoods tblGoods = goodsService.getGoodsById(new BigDecimal(pkId));
        if (tblGoods == null){
            model.addAttribute("message","商品不存在");
            return "inout";
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TblUserinfo user = (TblUserinfo)httpSession.getAttribute("user");
        System.out.println(user.getUsinName());
        if (inout.equals("in")){
            tblGoods.setGoodsInventory(tblGoods.getGoodsInventory()+Double.parseDouble(goodsInventory));
            TblRecords tblRecords = new TblRecords(new BigDecimal(pkId),df.format(new Date()).toString(),"入库",user.getUsinUsername(),goodsInventory);
            goodsService.update(tblGoods);
            recodService.insert(tblRecords);
        }else if (inout.equals("out")){
            if (tblGoods.getGoodsInventory()<Double.parseDouble(goodsInventory)) {
                model.addAttribute("message","库存不足");
                return "inout";
            }else{
                tblGoods.setGoodsInventory(tblGoods.getGoodsInventory()-Double.parseDouble(goodsInventory));
                TblRecords tblRecords = new TblRecords(new BigDecimal(pkId),df.format(new Date()).toString(),"出库",user.getUsinUsername(),goodsInventory);
                goodsService.update(tblGoods);
                recodService.insert(tblRecords);
            }
        }
        return "redirect:inout";
    }

}
