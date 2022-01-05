package com.github.itliwei;

import com.github.itliwei.mybatis.base.IdEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author : liwei
 * @date : 2022/01/06 00:40
 * @description : ${TODO}
 */
public interface MyBaseMapper<T> extends Mapper<T>, InsertListMapper<T>, IdsMapper<T> {

}