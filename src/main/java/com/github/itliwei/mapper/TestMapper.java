package com.github.itliwei.mapper;

import com.github.itliwei.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : liwei
 * @date : 2022/01/06 00:40
 * @description : ${TODO}
 */
@Mapper
public interface TestMapper {

    @Select("SELECT * FROM user where id = #{id} ")
    List<User> findById(@Param("id") Long id);

}
