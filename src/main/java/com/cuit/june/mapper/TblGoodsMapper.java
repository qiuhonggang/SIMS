package com.cuit.june.mapper;

import com.cuit.june.pojo.TblGoods;

import java.math.BigDecimal;

public interface TblGoodsMapper extends BaseMapper<TblGoods>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_GOODS
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(BigDecimal pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_GOODS
     *
     * @mbggenerated
     */
    int insert(TblGoods tblGoods);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_GOODS
     *
     * @mbggenerated
     */
    int insertSelective(TblGoods tblGoods);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_GOODS
     *
     * @mbggenerated
     */
    TblGoods selectByPrimaryKey(BigDecimal pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_GOODS
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TblGoods tblGoods);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_GOODS
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TblGoods tblGoods);

    /**
     * 更新库存信息
     * @param id
     */
    void update(TblGoods tblGoods);
}