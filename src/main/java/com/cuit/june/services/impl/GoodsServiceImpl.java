package com.cuit.june.services.impl;

import com.cuit.june.mapper.TblGoodsMapper;
import com.cuit.june.pojo.TblGoods;
import com.cuit.june.services.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qhg on 16/5/31.
 */
@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService{

    @Resource
    TblGoodsMapper tblGoodsMapper;

    /**
     * 根据商品ID返回商品信息
     *
     * @param id 商品id
     * @return
     * @throws Exception
     */
    public TblGoods getGoodsById(BigDecimal id)throws Exception {
        return tblGoodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 返回所有商品信息
     *
     * @return 商品信息列表
     * @throws Exception
     */
    public List<TblGoods> getAllGoodsList() throws Exception {
        return tblGoodsMapper.getAllList();
    }

    /**
     * 添加商品信息
     *
     * @param tblGoods
     * @throws Exception
     */
    public void addGoods(TblGoods tblGoods) throws Exception {
        if (tblGoods != null && !tblGoods.getGoodsName().equals("") && !tblGoods.getGoodsNumber().equals("")) {
            tblGoodsMapper.insert(tblGoods);
            System.out.println("插入商品信息成功----goodsname:" + tblGoods.getGoodsName());
        } else {
            throw new Exception("商品为空");
        }
    }

    /**
     * 更新商品信息
     *
     * @param tblGoods
     * @throws Exception
     */
    public void updateGoods(TblGoods tblGoods) throws Exception {
        if (tblGoods != null && tblGoods.getGoodsName()!= null && !tblGoods.getGoodsNumber().equals("")) {
            tblGoodsMapper.updateByPrimaryKey(tblGoods);
            System.out.println("更新商品信息成功----:" + tblGoods.getGoodsShelflife());
        } else {
            throw new Exception("商品为空");
        }
    }

    /**
     * 更新库存信息
     *
     * @param tblGoods
     * @throws Exception
     */
    public void update(TblGoods tblGoods) throws Exception {
            tblGoodsMapper.update(tblGoods);
    }

    /**
     * 删除商品信息
     *
     * @param id
     * @throws Exception
     */
    public void delGoods(BigDecimal id) throws Exception {
        System.out.println("进入删除方法" + id);
        if (id != null && !id.equals("") && getGoodsById(id) != null) {
            System.out.println("删除商品信息" + id);
            tblGoodsMapper.deleteByPrimaryKey(id);
            System.out.println("删除商品信息成功----goodsname:" + id);
        } else {
            throw new Exception("商品为空");
        }
    }
}
