package com.example.school.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/3 11:52
 */
@Data
@ApiModel(value = "changeClazz", description = "换班")
public class ChangeClazzDto {
    @ApiModelProperty(value = "学生ID")
    private Integer id;

    @ApiModelProperty(value = "新班级Code")
    private Integer classCode;
}
