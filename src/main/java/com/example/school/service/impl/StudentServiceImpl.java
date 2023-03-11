package com.example.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.school.dao.StudentMapper;
import com.example.school.dao.covert.StudentCovert;
import com.example.school.model.dto.ChangeClazzDto;
import com.example.school.model.dto.StudentQuery;
import com.example.school.model.dto.StudentDto;
import com.example.school.model.pojo.Student;
import com.example.school.model.vo.StudentPage;
import com.example.school.model.vo.StudentVo;
import com.example.school.service.StudentService;
import com.example.school.utils.ReflectUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 学生服务impl
 *
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/2 20:11
 */
@Transactional
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    /**
     * 查询学校所有学生以及条件查询学生，做分页处理
     *
     * @param studentQuery 学生查询条件
     * @param current      当前
     * @param limit        限制
     * @return {@link StudentPage}
     */
    @Override
    public StudentPage getStudent(StudentQuery studentQuery, long current, long limit) {
        Page<Student> studentpage = new Page<>(current, limit);
        QueryWrapper<Student> wrapper = new QueryWrapper<>();

        String studentName = studentQuery.getName();
        Integer studentSex = studentQuery.getSex();

        if(!StringUtils.isEmpty(studentName)){
            wrapper.like("name",studentName);
        }
        if(!StringUtils.isEmpty(studentSex)){
            wrapper.eq("sex",studentSex);
        }
        //根据id排序
        wrapper.orderByDesc("id");
        baseMapper.selectPage(studentpage, wrapper);
        List<Student> records = studentpage.getRecords();

        List<StudentVo> students;
        students = records.stream().map(student ->{
            StudentVo studentVo = StudentCovert.INSTANCE.toCovertVO(student);
            return studentVo;
        }).collect(Collectors.toList());

        return new StudentPage(students,studentpage.getTotal());
    }

    /**
     * 增加学生
     *
     * @param studentDto 学生dto
     * @return {@link Boolean}
     */
    @Override
    public Boolean addStudent(StudentDto studentDto) {
        Boolean result = false;
        if(ReflectUtil.isObjectNull(studentDto)){
            return result;
        }
        Student student = StudentCovert.INSTANCE.toCovertPO(studentDto);
        int insert = baseMapper.insert(student);
        if(insert > 0){
            result = true;
        }
        return result;
    }

    /**
     * 学生更换班级
     *
     * @param changeClazzDto 改变clazz dto
     * @return {@link Boolean}
     */
    @Override
    public Boolean changeStudentClazz(ChangeClazzDto changeClazzDto) {
        Boolean result = false;
        if(changeClazzDto == null){
            return result;
        }
        //学生id
        Integer sId = changeClazzDto.getId();
        //班级编号
        Integer class_code = changeClazzDto.getClassCode();
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        if(sId >0){
            wrapper.eq("id",sId);
        }
        if(! baseMapper.exists(wrapper)){
            return  result;
        }

        int update = baseMapper.changeStudentClazz(sId, class_code);
        if(update > 0){
            result = true;
        }
        return result;
    }


    /**
     * 获得指定班级下的所有学生
     *
     * @param classCode 班级编号
     * @param current   当前
     * @param limit     限制
     * @return {@link StudentPage}
     */
    @Override
    public StudentPage getStudentByClass(String classCode, long current, long limit) {
        Page<Student> page = new Page<>();
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.eq("class_code", classCode);

        baseMapper.selectPage(page, wrapper);
        List<Student> records = page.getRecords();
        List<StudentVo> students = null;
        students = records.stream().map(student ->{
            StudentVo studentVo = StudentCovert.INSTANCE.toCovertVO(student);
            return studentVo;
        }).collect(Collectors.toList());

        return new StudentPage(students,page.getTotal());
    }

    /**
     * 更新学生信息
     *
     * @param id         学生id
     * @param studentDto 学生dto
     * @return {@link Boolean}
     */
    @Override
    public Boolean updateStudent(Integer id, StudentDto studentDto) {
        Boolean isSuccess = false;
        Student student;
        if(studentDto == null){
          return isSuccess;
        }

        student = StudentCovert.INSTANCE.toCovertPO(studentDto);
        student.setId(id);

        int i = baseMapper.updateById(student);
        if(i > 0) {
            isSuccess = true;
        }
        return isSuccess;
    }

    /**
     * 删除学生
     *
     * @param id id
     * @return {@link Boolean}
     */
    @Override
    public Boolean deleteStudent(Integer id) {
        Boolean isDeleted = false;
        int delete = baseMapper.deleteById(id);
        if(delete > 0){
            isDeleted = true;
        }
        return isDeleted;
    }
}
