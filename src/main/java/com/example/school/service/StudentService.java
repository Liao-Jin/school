package com.example.school.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.school.model.dto.ChangeClazzDto;
import com.example.school.model.dto.StudentQuery;
import com.example.school.model.dto.StudentDto;
import com.example.school.model.pojo.Student;
import com.example.school.model.vo.StudentPage;
import com.example.school.model.vo.StudentVo;

import java.util.List;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/2 20:11
 */
public interface StudentService extends IService<Student> {


    /**
     * 查询班级下的学生，学校所有学生，做分页处理
     *
     * @param studentQuery clazz代码
     * @param current   当前
     * @param limit     限制
     * @return {@link List}<{@link StudentVo}>
     */
    StudentPage getStudent(StudentQuery studentQuery, long current, long limit);

    /**
     * 增加学生
     *
     * @param studentDto 学生dto
     * @return {@link Boolean}
     */
    Boolean addStudent(StudentDto studentDto);

    /**
     * 改变学生班级
     *
     * @param changeClazzDto 改变clazz dto
     * @return {@link Boolean}
     */
    Boolean changeStudentClazz(ChangeClazzDto changeClazzDto);

    /**
     * 获得指定班级下的所有学生
     *
     * @param classCode 类代码
     * @param current   当前
     * @param limit     限制
     * @return {@link StudentPage}
     */
    StudentPage getStudentByClass(String classCode, long current, long limit);

    /**
     * 更新学生信息
     *
     * @param id         学生id
     * @param studentDto 学生dto
     * @return {@link Boolean}
     */
    Boolean updateStudent(Integer id, StudentDto studentDto);

    /**
     * 删除学生
     *
     * @param id id
     * @return {@link Boolean}
     */
    Boolean deleteStudent(Integer id);
}
