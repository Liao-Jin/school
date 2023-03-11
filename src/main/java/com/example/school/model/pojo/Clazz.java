package com.example.school.model.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/2 14:03
 */
@Data
@ApiModel(value = "class",description = "班级")
public class Clazz {

    @ApiModelProperty(value = "班级编号")
    private Integer classCode;

    @ApiModelProperty(value = "班级描述")
    private String classDesc;
}
