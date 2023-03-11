package com.example.school.controller;

import com.example.school.dao.covert.StudentCovert;
import com.example.school.model.dto.ChangeClazzDto;
import com.example.school.model.dto.StudentQuery;
import com.example.school.model.dto.StudentDto;
import com.example.school.model.pojo.Student;
import com.example.school.model.vo.StudentPage;
import com.example.school.model.vo.StudentVo;
import com.example.school.service.StudentService;
import com.example.school.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/2 14:16
 */
@Api(tags = "学生模块接口")
@RestController
@CrossOrigin
@RequestMapping("/school/student")
public class StudentController {

    @Autowired
    public StudentService studentService;

    /**
     * 更新学生信息
     *
     * @param id         学生id
     * @param studentDto 学生dto
     * @return {@link Result}
     */
    @ApiOperation(value = "修改学生接口",
            notes = "描述:用来修改学生的接口")
    @PostMapping("/updateStudent/{id}")
    public Result updateStudent(@PathVariable("id") Integer id,
                                @RequestBody StudentDto studentDto){
        Boolean isSuccess = studentService.updateStudent(id,studentDto);
        return isSuccess ? Result.success().message("修改成功") : Result.error().message("修改失败");
    }


    /**
     * 添加学生
     *
     * @param studentDto 学生dto
     * @return {@link Result}
     */
    @ApiOperation(value = "添加学生接口",
                  notes = "描述:用来添加学生的接口")
    @PostMapping("/addStudent")
    public Result addStudent(@RequestBody StudentDto studentDto){
        Boolean result = studentService.addStudent(studentDto);
        return result ? Result.success():Result.error();
    }


    /**
     * 根据班级编号查询学生
     *
     * @param classCode 班级编号
     * @param current   当前页
     * @param limit     每页行数
     * @return {@link Result}
     */
    @ApiOperation(value ="查询学生接口",
                    notes = "描述：用来按照班级编号查询学生的接口")
    @PostMapping("/getStudentByClass/{classCode}/{current}/{limit}")
    public Result getStudentByClass(@PathVariable("classCode") String classCode,
                                    @PathVariable("current") long current,
                                    @PathVariable("limit") long limit){
        StudentPage studentPage =studentService.getStudentByClass(classCode,current,limit);
        return Result.success().data("students", studentPage);
    }

    @ApiOperation(value ="根据id查询学生接口",
            notes = "描述：用来按照学生id查询学生的接口")
    @GetMapping("/getStudentById/{id}")
    public Result getStudentById(@PathVariable Integer id){
        Student student = studentService.getById(id);
        StudentVo studentVo = StudentCovert.INSTANCE.toCovertVO(student);
        return Result.success().data("student", studentVo);
    }

    /**
     * 查询班级下的学生，学校所有学生,做分页处理
     *
     * @param studentQuery 查询条件
     * @param current   当前页
     * @param limit     每页限制数
     * @return {@link Result}
     */
    @ApiOperation(value = "查询所有学生以及条件查询学生，分页处理",
            notes = "<span style='color:red;'>描述:</span>&nbsp;用来查询所有或者符合条件的学生的接口")
    @PostMapping("/getStudentByQuery/{current}/{limit}")
    public Result getStudentorQuery(@RequestBody(required = false) StudentQuery studentQuery,
                                    @PathVariable("current") long current,
                                    @PathVariable("limit") long limit){
        StudentPage studentPage= studentService.getStudent(studentQuery, current, limit);
        return Result.success().data("students",studentPage);
    }

    @ApiOperation(value ="删除学生接口",
            notes = "描述：按照id逻辑删除学生的接口")
    @DeleteMapping("/deleteStudent/{id}")
    public Result deleteStudent(@PathVariable("id") Integer id){
        Boolean isDeleted = studentService.deleteStudent(id);
        return isDeleted ? Result.success().message("删除学生成功") : Result.error().message("删除失败");
    }

}
