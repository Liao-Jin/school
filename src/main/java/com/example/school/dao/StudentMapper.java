package com.example.school.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.school.model.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/2 20:28
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    int changeStudentClazz(int id, int class_code);
}
