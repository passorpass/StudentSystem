package com.student.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class Course {

    @TableField("CourseID")
    private Integer cid;
    @TableField("StudentID")
    private Integer stid;
    @TableField("SubjectID")
    private Integer sbid;
    @TableField("Grade")
    private Integer grade;

}
