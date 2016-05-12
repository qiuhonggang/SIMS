package com.cuit.june.mapper;

import com.cuit.june.pojo.TblRecords;

import java.math.BigDecimal;

public interface TblRecordsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_RECORDS
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(BigDecimal pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_RECORDS
     *
     * @mbggenerated
     */
    int insert(TblRecords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_RECORDS
     *
     * @mbggenerated
     */
    int insertSelective(TblRecords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_RECORDS
     *
     * @mbggenerated
     */
    TblRecords selectByPrimaryKey(BigDecimal pkId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_RECORDS
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TblRecords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table TBL_RECORDS
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TblRecords record);
}