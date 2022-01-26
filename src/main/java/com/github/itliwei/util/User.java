package com.github.itliwei.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : liwei
 * @date : 2022/01/26 22:21
 * @description : ${TODO}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;

    @FieldInfo(desc = "年龄")
    private Integer age;

    private Byte status;

    private Date birthday;
}
