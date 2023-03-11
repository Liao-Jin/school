package com.example.school.model.vo;

import com.example.school.model.pojo.Clazz;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/7 10:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "clazzPage",description = "班级展示对象")
public class ClazzPage {
    @ApiModelProperty(value = "班级列表")
    private List<Clazz> records;

    @ApiModelProperty(value = "查询出的班级总数")
    private Long total;
}
