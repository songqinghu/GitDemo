package com.git.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.git.utils.MD5Utils;

/**
 * 通过反射获取类中的泛型类型
 * @author songqinghu
 *
 */
public class GenericTypeUtils {


    public static Class getGenericType(Class obj){
        
        Type type = obj.getGenericSuperclass();
        System.out.println(type);
        if(type instanceof ParameterizedType){
            ParameterizedType generic =  (ParameterizedType)type;
            Type[] types = generic.getActualTypeArguments();
            return (Class) types[0];
        }
        return null;
    }
    
    
}
