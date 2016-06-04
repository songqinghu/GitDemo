package com.git.base.reflect.contrustion.tree;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import com.google.common.primitives.Primitives;

public class ContrustionTreeShow {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        //getTree();
        operationMethod();
    }
    
    
    public static void getTree() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        //获取字节码
         Class<?> sun = Class.forName("com.git.base.reflect.contrustion.tree.Sun");
         Class temp = sun;
         //获取全部的接口和父类
         while(true){
             if(temp!=Object.class){
                 Class<?>[] interfaces = temp.getInterfaces();
                 for (Class<?> in : interfaces) {
                     System.out.println(in.getName());
                 }
                 System.out.println(temp.getName());
                 temp = temp.getSuperclass();
             }else{
                 System.out.println(temp);
                 break;
             }
         }
         //获取全部的构造方法
         Constructor<?>[] constructors = sun.getConstructors();
         for (Constructor<?> constructor : constructors) {
             System.out.println(constructor);
             StringBuilder sb = new StringBuilder();
             //修饰符
             int mod = constructor.getModifiers();
             String statement = Modifier.toString(mod);
             sb.append(statement).append(" ");
             //类名称
             String name = constructor.getName();
             sb.append(name).append("(");
             //方法参数
             Class<?>[] parameterTypes = constructor.getParameterTypes();
             
             for (int i = 0; i < parameterTypes.length; i++) {
                
                 sb.append(parameterTypes[i].getName());
                 if(i != parameterTypes.length -1){
                     sb.append(",");
                 }
             }
             sb.append(")") ; 
             System.out.println(sb.toString());
             System.out.println();
         }
         //取得全部类中全部的方法
         
         Method[] methods = sun.getMethods();//全部的方法
         
         for (Method method : methods) {
            StringBuilder sb = new StringBuilder();
            
             int mod = method.getModifiers();
             String statement = Modifier.toString(mod);//方法修饰
             sb.append(statement);
             
             Class<?> returnType = method.getReturnType();
             String simpleName = returnType.getSimpleName();//返回值的简单名称
             sb.append(" ").append(simpleName);
             
             String name = method.getName();//方法名称
             sb.append(" ").append(name);
             
             Class<?>[] parameterTypes = method.getParameterTypes();
             sb.append("(");
             for (int i = 0; i < parameterTypes.length; i++) {
                sb.append(parameterTypes[i].getName());
                if(i != parameterTypes.length -1){
                    sb.append(",");
                }
             }
             sb.append(")");
             System.out.println(sb.toString());
         }
         
         //获取所有的属性信息
         Field[] declaredFields = sun.getDeclaredFields();//本类中的属性
         for (Field field : declaredFields) {
            int modifiers = field.getModifiers();
            String statement = Modifier.toString(modifiers);
            
            Class<?> type = field.getType();
            
            String name2 = type.getSimpleName();
            
            String name = field.getName();
            System.out.println(statement + " " + name2 + "  " + name);
         }
         System.out.println();
         Field[] fields = sun.getFields();//父类中的公共属性 ---私有属性获取不到  可以通过向上转型获取 属性
         
         for (Field field : fields) {
             
             int modifiers = field.getModifiers();
             String statement = Modifier.toString(modifiers);
             
             Class<?> type = field.getType();
             
             String name2 = type.getSimpleName();
             
             String name = field.getName();
             System.out.println(statement + " " + name2 + "  " + name);
         }
         
         
         
    }
    
    //反射获取类中全部的属性 和进行set get 操作
    public static void operationMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
        
        Class<?> clazz = Class.forName("com.git.base.reflect.contrustion.tree.Sun");
        
        //获取所有的属性名称  子类 父类 直到 object
        StringBuilder sb = new StringBuilder();
        Class temp = clazz;
        HashMap<String, Field> fieldMap = new HashMap<String,Field>();
        while(true){
            if(temp != Object.class){
                Field[] declaredFields = temp.getDeclaredFields();
                
                for (Field field : declaredFields) {
                    
                    String methodName = field.getName();
                    fieldMap.put(methodName, field);
                    sb.append(methodName).append(" ");
                    
                }
                temp = temp.getSuperclass();
            }else{
                break;
            }
        }
        //获取公共的属性
        
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
             fieldMap.put(field.getName(), field);
             sb.append(field.getName()).append(" ");
        }

        //对给定的属性进行注入操作  提供 name 和注入的值 value 模仿spring 
        
        String properties = "age";
        String value = "10";
        
        Field field = fieldMap.get(properties);
        //使用set方法进行注入
        Object obj = clazz.newInstance();
        Class<?> type = field.getType();
        System.out.println(type);
        
        //参数类型转换 设置 基本类型到 包装类的映射
        Class<?> wrap = Primitives.wrap(type);
        
        Constructor<?> params = wrap.getConstructor(String.class);
        Object v = params.newInstance(value);//将字符串转为数字
        
        setProperties(obj, properties, v, type);
        
        Object result = getProperties(obj, properties);
        System.out.println(result);
    }
    //设置属性 的方法
    /**
     * 
     * @描述：XXXXXXX
     * @param obj 反射获取的实例化对象
     * @param properties 要设置的属性名
     * @param params 设置的值
     * @param type 要设置的方法的参数类型
     * @return void
     * @exception
     * @createTime：2016年6月3日
     * @author: songqinghu
     */
    private static void setProperties(Object obj,String properties,Object params,Class<?> type) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        
         Method setXx = obj.getClass().getMethod(getProperties("set",properties),type);
         setXx.invoke(obj, params);
    }
    //获取指定属性的信息
    private static Object getProperties(Object obj,String properties) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        
        Method getXx = obj.getClass().getMethod(getProperties("get", properties));
        
        Object invoke = getXx.invoke(obj);
        
        return invoke;
    }
    
    
    //属性操作方法名
    private static String getProperties(String prefix,String properties){
       properties = prefix+ properties.substring(0,1).toUpperCase()+properties.substring(1);
       return properties;
    }
    
    //获取指定的构造方法进行实例化
    public static void getSpecifyContructor() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        
        Class<?> sun = Class.forName("com.git.base.reflect.contrustion.tree.Sun");
        
        Constructor<?> constructor = sun.getConstructor(String.class,int.class);
        
        Object object = constructor.newInstance("小明",18);
        
        System.out.println(object);
        
    }

    
    
}
