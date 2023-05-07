package com.student.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin")
public class Admin {


    @TableField("AdminID")
    private Integer id;
    @TableField("UserName")
    private String username;
    @TableField("Age")
    private Integer age;
    @TableField("Gender")
    private String sex;
    @TableField("Password")
    private String password;



}
