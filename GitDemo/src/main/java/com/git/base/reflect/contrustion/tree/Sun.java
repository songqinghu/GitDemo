package com.git.base.reflect.contrustion.tree;

public class Sun  extends Parent{

    private String say;
    
    public Sun(){
        
    }
    
    public Sun(String name){
        this.setName(name);
    }
    
    public Sun(String name,int age){
        this.setName(name);
        this.setAge(age);
    }

    
    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    @Override
    public String toString() {
        return "Sun [Like=" + getLike() + ", Name=" + getName() + ", Age=" + getAge() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() ;
    }
}
