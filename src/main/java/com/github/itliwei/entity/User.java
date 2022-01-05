package com.github.itliwei.entity;

import com.github.itliwei.mybatis.base.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : liwei
 * @date : 2022/01/06 00:40
 * @description : ${TODO}
 */
@Data
@Table(name = "USER")//如果实体类名字与数据库不一致又不使用注解会报错
public class User extends IdEntity implements Serializable {

	private String username;//用户名
	private String password;//密码
 
}
