package com.github.itliwei.mybatis.base;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BaseDao<T extends IdEntity> {
    int save(T t);

    int delete(T t);

    int deleteById(Long id);

    int update(T t);

    T getById(Long id);

    List<T> getAll();

    int saveAll(List<T> list);

    List<T> searchByExample(Example example);

    PageInfo<T> findByPage(int pageNum,int pageSize,Example example);

}
