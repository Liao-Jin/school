package com.example.school.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.school.model.dto.ClazzDto;
import com.example.school.model.dto.ClazzQuery;
import com.example.school.model.pojo.Clazz;
import com.example.school.model.vo.ClazzPage;

import java.util.Map;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/2 14:34
 */

public interface ClazzService extends IService<Clazz> {


    /**
     * 添加clazz对象
     *
     * @param clazzDto
     */
    Boolean addClazz(ClazzDto clazzDto);


    /**
     * 条件查询查询clazz
     *
     * @param current    当前
     * @param limit      限制
     * @param clazzQuery clazz查询
     * @return {@link ClazzPage}
     */
    ClazzPage getClazzByQuery(long current, long limit, ClazzQuery clazzQuery);
}
