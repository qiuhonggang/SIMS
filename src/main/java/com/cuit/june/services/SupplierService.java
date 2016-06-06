package com.cuit.june.services;

import com.cuit.june.pojo.TblSupplier;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qhg on 16/6/1.
 */
public interface SupplierService {

    /**
     * 根据ID获取供应商
     * @param id
     * @return
     */
    TblSupplier getSupplierById(BigDecimal id) throws Exception;

    /**
     * 获取所有供应商信息
     * @return
     * @throws Exception
     */
    List<TblSupplier> getAllSupplierList() throws Exception;

    /**
     * 添加供应商信息
     * @param tblSupplier 供应商
     * @throws Exception
     */
    void addSupplier(TblSupplier tblSupplier) throws Exception;

    /**
     * 更新供应商信息
     * @param tblSupplier
     * @throws Exception
     */
    void updateSupplier(TblSupplier tblSupplier) throws Exception;

    /**
     * 删除供应商信息
     * @param id
     * @throws Exception
     */
    void delSupplier(BigDecimal id) throws Exception;
}
