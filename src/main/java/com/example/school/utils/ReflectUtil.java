package com.example.school.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Lenovo
 * @version 1.0.0
 * @description 判断对象是否为空
 * @date 2023/3/4 23:28
 */
public class ReflectUtil {
    public static boolean isObjectNull(Object obj){
        if (obj != null) {
            Class<?> objClass = obj.getClass();
            Method[] declaredMethods = objClass.getDeclaredMethods();
            if (declaredMethods.length > 0) {
                int methodCount = 0; // get 方法数量
                int nullValueCount = 0; // 结果为空

                for (Method declaredMethod : declaredMethods) {
                    String name = declaredMethod.getName();
                    if (name.startsWith("get") || name.startsWith("is")){
                        methodCount += 1;
                        try {
                            Object invoke = declaredMethod.invoke(obj);
                            if (invoke == null) {
                                nullValueCount += 1;
                            }
                        } catch (IllegalAccessException | InvocationTargetException e){
                            e.printStackTrace();
                        }
                    }
                }
                return methodCount == nullValueCount;
            }
        }
        return false;
    }
}
