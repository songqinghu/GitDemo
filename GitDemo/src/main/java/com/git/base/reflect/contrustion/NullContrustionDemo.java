package com.git.base.reflect.contrustion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class NullContrustionDemo {

   
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Girl girl = new Girl();
        
        Class<? extends Girl> class1 = girl.getClass();
        
        
        Class<? extends Girl> class2 =  Girl.class;
        
        Class<?> class3 = Class.forName("com.git.base.reflect.contrustion.Girl");
        
        
        System.out.println(class1.getName());
        System.out.println(class2.getName());
        System.out.println(class3.getName());
        
        Object object = class3.newInstance();
        
        Method[] methods = class3.getMethods();
        //for (Method method : methods) {
      //      TypeVariable<Method>[] typeParameters = method.getTypeParameters();
     //       
    //        method.invoke(object, "lili");
     //   }
        
    }
}
