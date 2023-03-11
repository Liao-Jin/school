package com.example.school.dao.covert;

import com.example.school.model.dto.ClazzDto;
import com.example.school.model.pojo.Clazz;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-08T09:27:43+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_321 (Oracle Corporation)"
)
public class ClazzCovertImpl implements ClazzCovert {

    @Override
    public Clazz toCovertPO(ClazzDto clazzDto) {
        if ( clazzDto == null ) {
            return null;
        }

        Clazz clazz = new Clazz();

        clazz.setClassDesc( clazzDto.getClassDesc() );

        return clazz;
    }
}
