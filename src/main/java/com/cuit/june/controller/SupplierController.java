package com.cuit.june.controller;

import com.cuit.june.pojo.TblSupplier;
import com.cuit.june.services.SupplierService;
import com.cuit.june.util.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qhg on 16/6/4.
 */
@Controller
@RequestMapping(value = "/")
public class SupplierController {
    @Resource
    SupplierService supplierService;

    @RequestMapping(value = "supplier")
    public String supplier(Model model) throws Exception {
        List<TblSupplier> tblSupplierList = supplierService.getAllSupplierList();
        model.addAttribute("tblSupplierList", JsonUtil.toJson(tblSupplierList));
        return "supplier";
    }

    @RequestMapping(value = "operSupplier")
    public String operSupplier(String oper, String pkId, String suppNumber, String suppName, String suppPhone, String suppAddr) throws Exception {
        TblSupplier tblSupplier;
        if(oper.equals("add")){
            tblSupplier = new TblSupplier(suppNumber, suppName, suppPhone,suppAddr);
            supplierService.addSupplier(tblSupplier);
        }else if (oper.equals("edit")){
            tblSupplier = new TblSupplier(new BigDecimal(pkId), suppNumber, suppName, suppPhone,suppAddr);
            supplierService.updateSupplier(tblSupplier);
        }else if(oper.equals("del")){
            supplierService.delSupplier(new BigDecimal(pkId));
        }
        return "supplier";
    }

}
