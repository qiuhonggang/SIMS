package com.cuit.june.services.impl;

import com.cuit.june.mapper.TblSupplierMapper;
import com.cuit.june.pojo.TblSupplier;
import com.cuit.june.services.SupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qhg on 16/6/4.
 */
@Service("SupplierService")
public class SupplierServiceImpl implements SupplierService {

    @Resource
    private TblSupplierMapper tblSupplierMapper;

    /**
     * 根据ID获取供应商
     *
     * @param id
     * @return
     */
    public TblSupplier getSupplierById(BigDecimal id) throws Exception {
        return tblSupplierMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取所有供应商信息
     *
     * @return
     * @throws Exception
     */
    public List<TblSupplier> getAllSupplierList() throws Exception {
        return tblSupplierMapper.getAllList();
    }

    /**
     * 添加供应商信息
     *
     * @param tblSupplier 供应商
     * @throws Exception
     */
    public void addSupplier(TblSupplier tblSupplier) throws Exception {
        if (tblSupplier != null && !tblSupplier.getSuppName().equals("") && tblSupplier.getSuppName() != null) {
            tblSupplierMapper.insert(tblSupplier);
            System.out.println("插入供应商信息成功----username:" + tblSupplier.getSuppName());
        } else {
            throw new Exception("供应商信息为空");
        }
    }

    /**
     * 更新供应商信息
     *
     * @param tblSupplier
     * @throws Exception
     */
    public void updateSupplier(TblSupplier tblSupplier) throws Exception {
        if (tblSupplier != null && !tblSupplier.getSuppName().equals("") && tblSupplier.getSuppName() != null) {
            tblSupplierMapper.updateByPrimaryKey(tblSupplier);
            System.out.println("更新供应商信息成功----username:" + tblSupplier.getSuppName());
        } else {
            throw new Exception("供应商信息为空");
        }
    }

    /**
     * 删除供应商信息
     *
     * @param id
     * @throws Exception
     */
    public void delSupplier(BigDecimal id) throws Exception {
        if (id != null && !id.equals("") && getSupplierById(id) != null) {
            System.out.println("删除供应商信息" + id);
            tblSupplierMapper.deleteByPrimaryKey(id);
            System.out.println("供应商姓名----username:" + id);
        } else {
            throw new Exception("供应商为空");
        }
    }
}
