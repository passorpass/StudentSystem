package com.student.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Transient;


@Data
@TableName("admin")
public class Admin {


    @TableField("AdminID")
    private Long id;
    @TableField("UserName")
    private String username;
    @TableField("Age")
    private Integer age;
    @TableField("Gender")
    private String sex;
    @TableField("Password")
    private String password;

    @Transient // 表示该字段不需要持久化到数据库
    private String token;

    // 其他字段和方法省略

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}




