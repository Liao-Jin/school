package com.example.school.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/7 10:21
 */
@Data
@ApiModel(value = "ClazzQuery", description="查询班级的条件")
public class ClazzQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班级描述")
    private String classDesc;
}
