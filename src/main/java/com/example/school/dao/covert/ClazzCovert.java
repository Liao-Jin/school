package com.example.school.dao.covert;

import com.example.school.model.dto.ClazzDto;
import com.example.school.model.pojo.Clazz;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/3 11:08
 */
@Mapper
public interface ClazzCovert {
    ClazzCovert INSTANCE = Mappers.getMapper(ClazzCovert.class);

    //DTO转为PO
    Clazz toCovertPO(ClazzDto clazzDto);
}
