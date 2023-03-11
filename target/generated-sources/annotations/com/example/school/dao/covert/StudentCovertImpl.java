package com.example.school.dao.covert;

import com.example.school.model.dto.StudentDto;
import com.example.school.model.pojo.Student;
import com.example.school.model.vo.StudentVo;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-08T23:01:25+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_321 (Oracle Corporation)"
)
public class StudentCovertImpl implements StudentCovert {

    @Override
    public StudentVo toCovertVO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentVo studentVo = new StudentVo();

        studentVo.setId( student.getId() );
        studentVo.setName( student.getName() );
        studentVo.setAge( student.getAge() );
        studentVo.setClassCode( student.getClassCode() );

        studentVo.setSex( student.getSex()==1 ? "男" : "女" );

        return studentVo;
    }

    @Override
    public Student toCovertPO(StudentDto studentDto) {
        if ( studentDto == null ) {
            return null;
        }

        Student student = new Student();

        student.setName( studentDto.getName() );
        student.setAge( studentDto.getAge() );
        student.setSex( studentDto.getSex() );
        student.setClassCode( studentDto.getClassCode() );

        return student;
    }
}
