package com.cuit.june.services.impl;

import com.cuit.june.mapper.TblRecordsMapper;
import com.cuit.june.pojo.TblRecords;
import com.cuit.june.services.RecodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qhg on 16/6/5.
 */
@Service("RecodeService")
public class RecodeServiceImpl implements RecodService {

    @Resource
    TblRecordsMapper tblRecordsMapper;

    /**
     * 获取所有记录信息
     *
     * @return
     * @throws Exception
     */
    public List<TblRecords> getAllRecodeList() throws Exception {
        return tblRecordsMapper.getAllList();
    }

    /**
     * 插入记录
     *
     * @param tblRecords
     * @throws Exception
     */
    public void insert(TblRecords tblRecords) throws Exception {
        tblRecordsMapper.insert(tblRecords);
    }
}
