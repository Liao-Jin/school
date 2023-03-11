package com.example.school.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/3 10:15
 */
@Data
@ApiModel(value = "clazzDto",description = "班级处理对象")
public class ClazzDto {

    @ApiModelProperty(value = "班级描述")
    private String classDesc;
}
