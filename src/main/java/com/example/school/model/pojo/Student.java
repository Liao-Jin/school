package com.example.school.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.example.school.model.dto.StudentDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/2 13:56
 */
@Data
@ApiModel(value = "Student", description = "学生对象")
public class Student {

    @ApiModelProperty(value = "学生ID")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别,0为女，1为男")
    private Integer sex;

    @ApiModelProperty(value = "班级code")
    private Integer classCode;

    @ApiModelProperty(value = "逻辑删除,1（true）已删除,0（false）未删除")
    @TableLogic
    private Integer isDeleted;
}
