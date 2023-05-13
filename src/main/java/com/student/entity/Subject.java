package com.student.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("subject")
public class Subject {

    @TableField("SubjectID")
    private Long id;
    @TableField("SubjectName")
    private String name;
    @TableField("Credit")
    private Integer credit;
}
