package com.github.itliwei.mybatis.base;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author : liwei
 * @date : 2022/01/06 00:40
 * @description : ${TODO}
 */
@Data
public abstract class IdEntity {

    public static final String ID_PN = "id";

    @Id
    @Column(name = ID_PN)// 注解声明该表的字段名
    private Long id;


}
