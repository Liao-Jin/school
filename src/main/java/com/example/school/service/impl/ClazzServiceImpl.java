package com.example.school.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.school.dao.ClazzMapper;
import com.example.school.model.dto.ClazzDto;
import com.example.school.model.dto.ClazzQuery;
import com.example.school.model.pojo.Clazz;
import com.example.school.model.vo.ClazzPage;
import com.example.school.service.ClazzService;
import com.example.school.utils.ReflectUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description TODO
 * @date 2023/3/2 14:34
 */
@Service
@Transactional
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper,Clazz> implements ClazzService{

    @Override
    public Boolean addClazz(ClazzDto clazzDto) {
        boolean result = false;

        //如果为空，直接返回false结果
        if(ReflectUtil.isObjectNull(clazzDto)){
            return result;
        }
        Clazz clazz = new Clazz();
        BeanUtils.copyProperties(clazzDto,clazz);

        int insert = baseMapper.insert(clazz);
        if(insert > 0){
            result = true;
        }

        return result;
    }

    /**
     * 条件查询班级
     *  ClazzQuery下有 classDesc
     * @param current    当前
     * @param limit      限制
     * @param clazzQuery clazz查询
     * @return {@link ClazzPage}
     */
    @Override
    public ClazzPage getClazzByQuery(long current, long limit, ClazzQuery clazzQuery) {
        String classDesc = clazzQuery.getClassDesc();

        Page<Clazz> clazzPage = new Page<>(current,limit);
        QueryWrapper<Clazz> wrapper = new QueryWrapper<>();
        //如果有条件，添加查询条件
        if(!StringUtils.isEmpty(classDesc)){
            wrapper.like("class_desc",classDesc);
        }
        //按照class_code，降序排序
        wrapper.orderByDesc("class_code");

        baseMapper.selectPage(clazzPage,wrapper);
        ClazzPage clazzs = new ClazzPage(clazzPage.getRecords(),clazzPage.getTotal());
        return clazzs;
    }


}
