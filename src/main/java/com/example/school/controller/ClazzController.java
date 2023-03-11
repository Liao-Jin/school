package com.example.school.controller;

import com.example.school.model.dto.ClazzDto;
import com.example.school.model.dto.ClazzQuery;
import com.example.school.model.pojo.Clazz;
import com.example.school.model.vo.ClazzPage;
import com.example.school.service.ClazzService;
import com.example.school.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * @author Lj
 * @version 1.0.0
 * @description 班级控制层
 * @date 2023/3/3 11:24
 */
@Api(tags = "班级模块接口")
@CrossOrigin
@RestController
@RequestMapping("/school/clazz")
public class ClazzController {

    @Autowired
    public ClazzService clazzService;

    @ApiOperation(value = "添加班级接口",
            notes = "描述:用来添加班级的接口")
    @PostMapping("/addClazz")
    public Result addClazz(@RequestBody ClazzDto clazzDto){
        Boolean aBoolean = clazzService.addClazz(clazzDto);
        return aBoolean ? Result.success().message("创建成功") : Result.error().message("创建失败");
    }

    @ApiOperation(value = "获得所有班级接口",
            notes = "描述:用来获得所有班级，不分页的接口")
    @GetMapping("/getAllClazz")
    public Result getAllClazz(){
        List<Clazz> clazzList = clazzService.list();
        return Result.success().data("clazzList",clazzList);
    }

    @ApiOperation(value = "查询班级接口",
                    notes = "描述：用来条件查询以及获得所有班级，分页")
    @PostMapping("/getClazzByQuery/{current}/{limit}")
    public Result getClazzByQuery(@PathVariable("current") long current,
                                  @PathVariable("limit") long limit,
                                  @RequestBody(required = false) ClazzQuery clazzQuery){
       ClazzPage clazzPage = clazzService.getClazzByQuery(current, limit, clazzQuery);
        return Result.success().data("classPage", clazzPage);
    }


}
