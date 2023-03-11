package com.example.school.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/8 18:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolException extends RuntimeException{
    private Integer code;//状态码

    private String msg;//异常状态信息
}
