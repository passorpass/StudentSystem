package com.student.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student {

    @TableField("StudentID")
    private Long id;

    @TableField("Name")
    private String name;

    @TableField("Age")
    private Integer age;

    @TableField("Gender")
    private String sex;

    @TableField("Class")
    private String cls;

    @TableField("Password")
    private String password;


}
