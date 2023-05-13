package com.student.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("teacher")
public class Teacher {

    @TableField("TeacherID")
    private Long id;
    @TableField("Name")
    private String name;
    @TableField("Age")
    private Integer age;
    @TableField("Gender")
    private String sex;
    @TableField("Subject")
    private String subject;
    @TableField("Password")
    private String password;
}
