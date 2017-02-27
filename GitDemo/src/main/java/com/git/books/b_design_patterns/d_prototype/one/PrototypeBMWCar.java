package com.git.books.b_design_patterns.d_prototype.one;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @Description: bmwcar 实体类
 * @author: songqinghu
 * @date: 2017年2月27日 下午7:25:33
 * Version:1.0
 */
public class PrototypeBMWCar implements PrototypeCar {

    /**
     * 
     */
    private static final long serialVersionUID = -3622417086664448880L;

    private String brand ;
    
    private BMWCarEngine engine ;
    
    public PrototypeBMWCar() {
        brand = "bmw";
        engine = new BMWCarEngine();
        engine.setSound("wuwuwu~~");
    }
    
    @Override
    public void run() {
        System.out.println("the brand is : " + brand + " and the engine sound is : " + engine.getSound());
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BMWCarEngine getEngine() {
        return engine;
    }

    public void setEngine(BMWCarEngine engine) {
        this.engine = engine;
    }

    
    @Override
    protected Object clone() {
        
        Object car = null;
        
        try {
            car =  (Object) super.clone();
        } catch (CloneNotSupportedException e) {
           System.out.println("copy occor error!");
        }
        
        return car;
        
    }
    
    
    /**
     * 
     * @描述：流之深度拷贝
     * @return Object
     * @exception
     * @createTime：2017年2月27日
     * @author: songqinghu
     */
    protected Object deepClone(){
        
        Object car =null;
        
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(bo);
            out.writeObject(this);
            
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            
            ObjectInputStream oi = new ObjectInputStream(bi);
            
            car  = oi.readObject();
            
        } catch (IOException e) {
            
            e.printStackTrace();
            
        }finally{
            
            return car;
        }
        
    }
    
    
}
