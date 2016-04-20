package com.git.reflect;

public class GenericTypeBase<T> {

    
    public Class getEntity(){
       System.out.println(getClass());
       return GenericTypeUtils.getGenericType(getClass());
    }
    
    public void show(){
        System.out.println(getEntity());
    }
}
