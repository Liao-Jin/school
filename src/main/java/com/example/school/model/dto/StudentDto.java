package com.example.school.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/3 11:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "studentDto",description = "学生处理对象")
public class StudentDto {
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "班级code")
    private Integer classCode;
}
