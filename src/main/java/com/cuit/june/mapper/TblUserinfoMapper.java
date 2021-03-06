package com.cuit.june.mapper;

import com.cuit.june.pojo.TblUserinfo;

import java.math.BigDecimal;

public interface TblUserinfoMapper extends BaseMapper{


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_USERINFO
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(BigDecimal pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_USERINFO
     *
     * @mbggenerated
     */
    int insert(TblUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_USERINFO
     *
     * @mbggenerated
     */
    int insertSelective(TblUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_USERINFO
     *
     * @mbggeated
     */
    TblUserinfo selectByPrimaryKey(BigDecimal pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_USERINFO
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TblUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_USERINFO
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TblUserinfo record);


}