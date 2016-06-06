package com.cuit.june.services;

import com.cuit.june.pojo.TblGoods;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qhg on 16/5/31.
 */
public interface GoodsService {

    /**
     * 根据商品ID返回商品信息
     * @param id 商品
     * @return
     * @throws Exception
     */
    TblGoods getGoodsById(BigDecimal id) throws Exception;

    /**
     * 返回所有商品信息
     * @return 商品信息列表
     * @throws Exception
     */
    List<TblGoods> getAllGoodsList() throws Exception;

    /**
     * 添加商品信息
     * @param tblGoods
     * @throws Exception
     */
    void addGoods(TblGoods tblGoods) throws Exception;

    /**
     * 更新商品信息
     * @param tblGoods
     * @throws Exception
     */
    void updateGoods(TblGoods tblGoods) throws Exception;

    /**
     * 删除商品信息
     * @param pkId
     * @throws Exception
     */
    void delGoods(BigDecimal pkId) throws Exception;

    /**
     * 更新库存信息
     * @param tblGoods
     * @throws Exception
     */
    void update(TblGoods tblGoods)throws Exception;
}
