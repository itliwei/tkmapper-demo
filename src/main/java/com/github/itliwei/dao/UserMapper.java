package com.github.itliwei.dao;

import com.github.itliwei.MyBaseMapper;
import com.github.itliwei.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author : liwei
 * @date : 2022/01/06 00:40
 * @description : ${TODO}
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends MyBaseMapper<User> {

}
