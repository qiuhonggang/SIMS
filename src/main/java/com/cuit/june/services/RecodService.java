package com.cuit.june.services;

import com.cuit.june.pojo.TblRecords;

import java.util.List;

/**
 * Created by qhg on 16/6/5.
 */
public interface RecodService {
    /**
     * 获取所有记录信息
     * @return
     * @throws Exception
     */
    List<TblRecords> getAllRecodeList() throws Exception;

    /**
     * 插入记录
     * @param tblRecords
     * @throws Exception
     */
    void insert(TblRecords tblRecords) throws Exception;
}
