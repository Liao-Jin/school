package com.example.school.dao.covert;

import com.example.school.model.dto.StudentDto;
import com.example.school.model.pojo.Student;
import com.example.school.model.vo.StudentVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/3 11:34
 */
@Mapper
public interface StudentCovert {
   StudentCovert INSTANCE =  Mappers.getMapper(StudentCovert.class);

   //po转vo
    @Mappings({
        @Mapping(target = "sex", expression = "java(student.getSex()==1 ? \"男\" : \"女\")")
    })
   StudentVo toCovertVO(Student student);

   //DTO 转 PO
   @Mappings({
   })
   Student toCovertPO(StudentDto studentDto);
}
