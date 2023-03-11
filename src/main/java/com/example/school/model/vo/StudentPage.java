package com.example.school.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/3 23:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentPage {
    private List<StudentVo> records;
    private Long total;
}
