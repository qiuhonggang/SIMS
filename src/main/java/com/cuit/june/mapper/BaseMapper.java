package com.cuit.june.mapper;

import java.util.List;

/**
 * Created by qhg on 16/5/9.
 */
public interface BaseMapper<T> {
    /**
     * 根据实体查询用户信息列表
     * @param entity
     * @return
     * @throws Exception
     */
    List<T> selectByEntity(T entity);

    /**
     * 返回所有实体信息
     * @return
     */
    List<T> getAllList();


}
