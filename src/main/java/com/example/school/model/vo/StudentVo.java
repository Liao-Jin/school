package com.example.school.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/2 19:56
 */
@Data
@ApiModel(value = "StudentVO", description = "学生展示对象")
public class StudentVo {
    @ApiModelProperty(value = "学生ID")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "班级编号")
    private Integer classCode;

}
