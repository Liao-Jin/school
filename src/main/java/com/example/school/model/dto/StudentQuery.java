package com.example.school.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/3 23:07
 */
@Data
public class StudentQuery implements Serializable {

    private static final long serialVersionUID =1L;

    //学生姓名
    private String name;

    //学生性别
    private Integer sex;
}
