package com.student.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class Course {

    @TableField("CourseID")
    private Long cid;
    @TableField("StudentID")
    private Long stid;
    @TableField("SubjectID")
    private Long sbid;
    @TableField("Grade")
    private Integer grade;

}
